package com.ajsw.microdb.repository;

import com.ajsw.microdb.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends MongoRepository<Request,String> {
    Request getRequestById(String id);
    Request deleteRequestById(String id);
}
