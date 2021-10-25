package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.LoginRequest;
import com.ajsw.microdb.dto.LoginResponse;
import com.ajsw.microdb.dto.UserRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Applicant;
import com.ajsw.microdb.model.Bidder;
import com.ajsw.microdb.model.Role;
import com.ajsw.microdb.repository.ApplicantRepository;
import com.ajsw.microdb.repository.BidderRepository;
import com.ajsw.microdb.repository.RoleRepository;
import com.ajsw.microdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ApplicantRepository applicantRepository;
    private final BidderRepository bidderRepository;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthenticationService(//BCryptPasswordEncoder bCryptPasswordEncoder,
                                 UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 ApplicantRepository applicantRepository,
                                 BidderRepository bidderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.applicantRepository = applicantRepository;
        this.bidderRepository = bidderRepository;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserRequest saveUser(UserRequest userRequest) {
        Applicant applicant = new Applicant();
        Bidder bidder = new Bidder();

        if(userRequest.getRole().equals("applicant")){
            applicant.setEmail(userRequest.getEmail());
            applicant.setPassword(userRequest.getPassword());
            //applicant.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
            applicant.setName(userRequest.getName());
            applicant.setLastname(userRequest.getLastname());
            applicant.setScore(userRequest.getScore());
            createUserRole(applicant,userRequest.getRole());
            applicantRepository.save(applicant);
        }else if(userRequest.getRole().equals("bidder")) {
            bidder.setEmail(userRequest.getEmail());
            bidder.setPassword(userRequest.getPassword());
            //bidder.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
            bidder.setName(userRequest.getName());
            bidder.setLastname(userRequest.getLastname());
            bidder.setScore(userRequest.getScore());
            createUserRole(bidder, userRequest.getRole());
            bidderRepository.save(bidder);
        }else{
            throw new SystemLoginException("");
        }
        return userRequest;
    }
    private void createUserRole(Bidder bidder,String role) {
        Role userRole = roleRepository.findByRole(role);
        if(bidder == null){
            throw new SystemLoginException("");
        }
        bidder.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    }
    private void createUserRole(Applicant applicant,String role) {
        Role userRole = roleRepository.findByRole(role);
        if(applicant == null){
            throw new SystemLoginException("");
        }
        applicant.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    }
    public LoginResponse login(LoginRequest loginRequest) {
        Applicant applicant = applicantRepository.findByEmail(loginRequest.getUser());
        Bidder bidder = bidderRepository.findByEmail(loginRequest.getUser());
        if(applicant!=null){
            if(applicant.getPassword().equals(loginRequest.getPassword())){
                return new LoginResponse(loginRequest.getUser(),applicant.getRoles());
            }
        }else if(bidder!=null){
            if(bidder.getPassword().equals(loginRequest.getPassword())){
                return new LoginResponse(loginRequest.getUser(),bidder.getRoles());
            }
        }else{
            throw new SystemLoginException("");
        }
        throw new SystemLoginException("");
    }
}
