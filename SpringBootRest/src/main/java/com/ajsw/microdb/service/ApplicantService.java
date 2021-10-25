package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.ApplicantRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Applicant;
import com.ajsw.microdb.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository){
        this.applicantRepository = applicantRepository;
    }
    public Applicant saveApplicant(ApplicantRequest applicantRequest){
        Applicant applicant = new Applicant();
        applicant.setEmail(applicantRequest.getEmail());
        applicant.setName(applicantRequest.getName());
        applicant.setLastname(applicantRequest.getLastname());
        applicant.setPassword(applicantRequest.getPassword());
        applicant.setRoles(applicantRequest.getRoles());
        applicant.setRequests(applicantRequest.getRequests());
        applicant.setScore(applicantRequest.getScore());
        return applicantRepository.save(applicant);
    }
    public Applicant delete(String id){
        Applicant applicant = applicantRepository.getApplicantById(id);
        if(applicant == null){
            throw new SystemLoginException("");
        }
        return applicantRepository.deleteApplicantById(id);
    }
    public Applicant updateApplicant(Applicant applicant){
        Applicant applicantUpdate = applicantRepository.getApplicantById(applicant.getId());
        applicantUpdate.setEmail(applicant.getEmail());
        applicantUpdate.setPassword(applicant.getPassword());
        applicantUpdate.setName(applicant.getName());
        applicantUpdate.setLastname(applicant.getLastname());
        applicantUpdate.setRoles(applicant.getRoles());
        applicantUpdate.setRequests(applicant.getRequests());
        applicantUpdate.setScore(applicant.getScore());
        applicantRepository.save(applicantUpdate);
        return applicantUpdate;
    }
    public List<Applicant> getAllApplicants(){
        return applicantRepository.findAll();
    }
    public Applicant getById(String id){
        return applicantRepository.getApplicantById(id);
    }
}
