package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.CreateUserRequest;
import com.ajsw.microdb.dto.LoginRequest;
import com.ajsw.microdb.dto.LoginResponse;
import com.ajsw.microdb.model.User;
import com.ajsw.microdb.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@RestController
public class LoginController {

    /*
    @Autowired
    private UserService userService;

    @PostMapping(path="/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }
    @PostMapping(path = "/registration")
    public ResponseEntity<Void> createNewUser(@RequestBody CreateUserRequest request) {
        userService.saveUser(request);
        return new ResponseEntity<Void>(HttpStatus.CREATED);

    }
    */
    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }*/
}
