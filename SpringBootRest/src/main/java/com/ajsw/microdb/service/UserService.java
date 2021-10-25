package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.CreateUserRequest;
import com.ajsw.microdb.dto.LoginRequest;
import com.ajsw.microdb.dto.LoginResponse;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Role;
import com.ajsw.microdb.model.User;
import com.ajsw.microdb.repository.RoleRepository;
import com.ajsw.microdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        //createRole();
    }

    private void createRole() {
        roleRepository.save(new Role("ADMIN"));
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUser());
        if(user == null){
            throw new SystemLoginException("");
        }else if(user.getPassword().equals(loginRequest.getPassword())){
            return new LoginResponse();//LoginResponse(user.getName(),user.getRoles());
        }
        throw new SystemLoginException("");
    }
}