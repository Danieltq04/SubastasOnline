package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.examplespring.pruebamvc.dto.UserRequest;
import com.examplespring.pruebamvc.model.Greeting;
import com.examplespring.pruebamvc.service.ApplicantService;
import com.examplespring.pruebamvc.service.AuthenticationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/ApplicantController")
@CrossOrigin("*")
@Api(tags = "Applicant")
public class ApplicantController {
    /*private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    @GetMapping("/example")
    List<ApplicantDTO> all() throws IOException {
        return applicantService.findAll();
    }
     */
    private final AuthenticationService authenticationService;
    @Autowired
    public ApplicantController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping("/index")
    public String greetingForms(Model model) {
        model.addAttribute("greeting", "Holaaa");
        return "index";
    }
    @PostMapping("/applicant")
    public String greetingSubmit(@ModelAttribute UserRequest request, Model model) throws IOException {
        //authenticationService.saveUser(request);
        return "redirect:/index";
    }
    @GetMapping("/applicant")
    public String greetingForm(Model model) {
        model.addAttribute("applicant", "Holaaa");
        return "applicant";
    }





}
