package com.examplespring.pruebamvc.service;

import com.examplespring.pruebamvc.dto.*;
import com.examplespring.pruebamvc.exception.SystemLoginException;
import com.examplespring.pruebamvc.model.Role;
import com.examplespring.pruebamvc.repository.RoleRepository;
import com.examplespring.pruebamvc.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final String URL = "http://localhost:8088/api";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private HttpClient httpClient = HttpClients.createDefault();

    @Autowired
    public AuthenticationService(
                                 UserRepository userRepository,
                                 RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public String saveUser(UserRequest userRequest) throws IOException {

        ApplicantDTO applicant = new ApplicantDTO();
        BidderDTO bidder = new BidderDTO();

        if(userRequest.getRole().equals("Solicitante")){
            applicant.setEmail(userRequest.getEmail());
            applicant.setPassword(userRequest.getPassword());
            applicant.setName(userRequest.getName());
            applicant.setLastname(userRequest.getLastname());
            applicant.setScore(userRequest.getScore());
            createUserRole(applicant,userRequest.getRole());


            HttpPost request = new HttpPost(URL+"/ApplicantController/");
            request.addHeader("content-type", "application/json");
            request.setEntity(new StringEntity(objectMapper.writeValueAsString(applicant)));
            HttpResponse response = httpClient.execute(request);
            String result = EntityUtils.toString(response.getEntity());
            return result;

        }else if(userRequest.getRole().equals("Ofertante")) {
            bidder.setEmail(userRequest.getEmail());
            bidder.setPassword(userRequest.getPassword());
            bidder.setName(userRequest.getName());
            bidder.setLastname(userRequest.getLastname());
            createUserRole(bidder, userRequest.getRole());

            HttpPost request = new HttpPost(URL+"/BidderController/");
            request.addHeader("content-type", "application/json");
            request.setEntity(new StringEntity(objectMapper.writeValueAsString(bidder)));
            HttpResponse response = httpClient.execute(request);
            String result = EntityUtils.toString(response.getEntity());
            return result;
        }else{
            throw new SystemLoginException("");
        }
    }

    private void createUserRole(BidderDTO bidder,String role) {
        Role userRole = roleRepository.findByRole(role);
        if(bidder == null){
            throw new SystemLoginException("");
        }
        bidder.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    }

    private void createUserRole(ApplicantDTO applicant,String role) {
        Role userRole = roleRepository.findByRole(role);
        if(applicant == null){
            throw new SystemLoginException("");
        }
        applicant.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
    }
    public LoginResponse login(LoginRequest loginRequest) {
        /*Applicant applicant = applicantRepository.findByEmail(loginRequest.getUser());
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
        */
        return new LoginResponse();
    }
}
