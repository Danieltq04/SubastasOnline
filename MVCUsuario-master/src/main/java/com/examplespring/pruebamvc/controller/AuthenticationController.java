package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.LoginRequest;
import com.examplespring.pruebamvc.dto.LoginResponse;
import com.examplespring.pruebamvc.dto.UserRequest;
import com.examplespring.pruebamvc.service.AuthenticationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/AuthenticationController")
@CrossOrigin("*")
@Api(tags = "Authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path="/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }
    @PostMapping(path="/registration")
    public String createNewUser(@RequestBody UserRequest userRequest) throws IOException {
        return authenticationService.saveUser(userRequest);
    }

}

