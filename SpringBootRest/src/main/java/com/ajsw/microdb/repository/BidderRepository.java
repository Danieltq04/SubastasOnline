package com.ajsw.microdb.repository;

import com.ajsw.microdb.model.Bidder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidderRepository extends MongoRepository<Bidder,String> {
    Bidder getBidderById(String id);
    Bidder deleteBidderById(String id);
    Bidder findByEmail(String email);
}
