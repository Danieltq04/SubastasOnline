package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.examplespring.pruebamvc.service.ApplicantService;
import com.examplespring.pruebamvc.service.AuthenticationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/ApplicantController")
@CrossOrigin("*")
@Api(tags = "Applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    @GetMapping("/example")
    List<ApplicantDTO> all() throws IOException {
        return applicantService.findAll();
    }
}
