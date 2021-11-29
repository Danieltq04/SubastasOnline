package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.UserRequest;
import com.examplespring.pruebamvc.service.AuthenticationService;
import com.examplespring.pruebamvc.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

@ApiIgnore
@Controller
public class OfferController {
    private final OfferService offerService;
    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offer")
    public String getOffers(Model model) throws IOException {
        model.addAttribute("offers", offerService.findAll());
        return "offer";
    }
}
