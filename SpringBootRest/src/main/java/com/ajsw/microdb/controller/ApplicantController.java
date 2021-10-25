package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.ApplicantRequest;
import com.ajsw.microdb.model.Applicant;
import com.ajsw.microdb.service.ApplicantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/")
    public List<Applicant> getAll(){
        return applicantService.getAllApplicants();
    }
    @GetMapping(value = "/{id}")
    public Applicant get(@PathVariable String id){
        return applicantService.getById(id);
    }
    @PostMapping(value = "/")
    public Applicant save(@RequestBody ApplicantRequest applicantRequest){
        return applicantService.saveApplicant(applicantRequest);
    }
    @DeleteMapping(value = "/{id}")
    public Applicant delete(@PathVariable String id){
        return applicantService.delete(id);
    }
    @PutMapping(value = "/")
    public Applicant update(@RequestBody Applicant applicant){
        return applicantService.updateApplicant(applicant);
    }

}
