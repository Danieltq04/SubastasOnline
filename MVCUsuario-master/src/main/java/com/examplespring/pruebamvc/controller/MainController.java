package com.examplespring.pruebamvc.controller;

import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/MainController")
@CrossOrigin("*")
@Api(tags = "Main")
public class MainController {

    @GetMapping(value = "/")
    public String welcome(Model model){
        model.addAttribute("nombre","Daniel");
        return "index2";
    }

}
