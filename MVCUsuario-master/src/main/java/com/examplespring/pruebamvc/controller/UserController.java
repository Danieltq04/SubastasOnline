package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.examplespring.pruebamvc.dto.UserRequest;
import com.examplespring.pruebamvc.service.AuthenticationService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/UserController")
@CrossOrigin("*")
@Api(tags = "User")
public class UserController {
    private final AuthenticationService authenticationService;
    @Autowired
    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("/user")
    public String greetingSubmit(@ModelAttribute UserRequest request, Model model) throws IOException {
        authenticationService.saveUser(request);
        return "redirect:/index";
    }

}
