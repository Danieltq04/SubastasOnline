package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.LoginRequest;
import com.ajsw.microdb.dto.LoginResponse;
import com.ajsw.microdb.dto.UserRequest;
import com.ajsw.microdb.service.AuthenticationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserRequest createNewUser(@RequestBody UserRequest userRequest) {
        return authenticationService.saveUser(userRequest);
    }
}

