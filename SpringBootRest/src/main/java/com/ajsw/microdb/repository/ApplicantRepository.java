package com.ajsw.microdb.repository;

import com.ajsw.microdb.model.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant,String> {
    Applicant getApplicantById(String id);
    Applicant deleteApplicantById(String id);
    Applicant findByEmail(String email);
}
