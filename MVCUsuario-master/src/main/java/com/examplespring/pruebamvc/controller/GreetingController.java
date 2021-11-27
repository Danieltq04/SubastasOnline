package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.examplespring.pruebamvc.model.Greeting;
import com.examplespring.pruebamvc.service.ApplicantService;
import com.examplespring.pruebamvc.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@ApiIgnore
@Controller
public class GreetingController {

    private final ApplicantService applicantService;

    @Autowired
    public GreetingController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    @GetMapping("/example")
    List<ApplicantDTO> all() throws IOException {
        return applicantService.findAll();
    }
    /*
    @GetMapping("/index")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", "Holaaa");
        return "index";
    }*/

    @GetMapping("/greeting")
    public String greetingForms2(Model model) throws IOException {
        model.addAttribute("greeting", applicantService.findAll());
        return "greeting";
    }


    @GetMapping("/index")
    public String greetingForm(Model model) {
        model.addAttribute("index", "Holaaa");
        return "index";
    }
    @GetMapping("/register")
    public String greetingForm2(Model model) {
        model.addAttribute("index", "Holaaa");
        return "register";
    }
    @GetMapping("/result")
    public String greetingForm22(Model model) {
        model.addAttribute("index", "Holaaa");
        return "result";
    }
    @GetMapping("/greetings")
    public String greetingForms(Model model) {
        model.addAttribute("greeting", "Holaaa");
        return "greeting";
    }
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

}