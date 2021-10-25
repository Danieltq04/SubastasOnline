package com.ajsw.microdb.repository;

import com.ajsw.microdb.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends MongoRepository<Offer,String> {
    Offer getOfferById(String id);
    Offer deleteOfferById(String id);
}
