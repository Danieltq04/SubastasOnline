package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.examplespring.pruebamvc.dto.UserRequest;
import com.examplespring.pruebamvc.model.CreateOffer;
import com.examplespring.pruebamvc.model.Greeting;
import com.examplespring.pruebamvc.model.Offer;
import com.examplespring.pruebamvc.service.ApplicantService;
import com.examplespring.pruebamvc.service.AuthenticationService;
import com.examplespring.pruebamvc.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@ApiIgnore
@Controller
public class GreetingController {

    private final ApplicantService applicantService;
    private final AuthenticationService authenticationService;
    private final OfferService offerService;

    @Autowired
    public GreetingController(ApplicantService applicantService,AuthenticationService authenticationService,
                              OfferService offerService) {
        this.applicantService = applicantService;
        this.authenticationService = authenticationService;
        this.offerService = offerService;
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
/*
    @GetMapping("/greeting")
    public String greetingForms2(Model model) throws IOException {
        model.addAttribute("greeting", applicantService.findAll());
        return "greeting";
    }
*/

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

    @GetMapping("/greeting")
    public String greetingForms(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }





    @GetMapping("/userRequest")
    public String greetingForm5(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "register";
    }

    @RequestMapping("/userRequest")
    public String greetingSubmit(@ModelAttribute UserRequest userRequest, Model model) throws IOException {
        model.addAttribute("userRequest", userRequest);

        if(userRequest.getEmail() == ""  || userRequest.getRole() == "Seleccione"
        || userRequest.getLastname() == "" || userRequest.getName() == ""
                || userRequest.getPassword() == ""){
            return "register";
        }
        else{
            String resultado = authenticationService.saveUser(userRequest);
            return "redirect:offer";
        }
        /*
        if(userRequest.getEmail() == ""){return "userRequest";}
        else{
            String resultado = authenticationService.saveUser(userRequest);
            return "offer";
        }*/

    }






    @GetMapping("/createOffer")
    public String greetingForm8(Model model) {
        model.addAttribute("createOffer", new CreateOffer());
        return "createOffer";
    }
    @RequestMapping("/createOffer")
    public String greetingSubmit14(@ModelAttribute CreateOffer createOffer, Model model) throws IOException {
        model.addAttribute("createOffer", createOffer);
        String resultado = offerService.saveOffer(createOffer);
        return "redirect:offer";
    }
}