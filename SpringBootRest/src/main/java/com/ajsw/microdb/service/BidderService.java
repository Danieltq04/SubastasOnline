package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.BidderRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.*;
import com.ajsw.microdb.repository.BidderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BidderService {
    private final BidderRepository bidderRepository;

    @Autowired
    public BidderService(BidderRepository bidderRepository){
        this.bidderRepository = bidderRepository;
    }
    public Bidder save(BidderRequest bidderRequest){
        Bidder bidder = new Bidder();
        bidder.setEmail(bidderRequest.getEmail());
        bidder.setName(bidderRequest.getName());
        bidder.setLastname(bidderRequest.getLastname());
        bidder.setPassword(bidderRequest.getPassword());
        bidder.setRoles(bidderRequest.getRoles());
        bidder.setOffers(bidderRequest.getOffers());
        bidder.setScore(bidderRequest.getScore());
        bidder.setComments(bidderRequest.getComments());
        return bidderRepository.save(bidder);
    }
    public Bidder delete(String id){
        Bidder bidder = bidderRepository.getBidderById(id);
        if(bidder == null){
            throw new SystemLoginException("");
        }
        return bidderRepository.deleteBidderById(id);
    }
    public Bidder update(Bidder bidder){
        Bidder bidderUpdate = bidderRepository.getBidderById(bidder.getId());
        bidderUpdate.setEmail(bidder.getEmail());
        bidderUpdate.setPassword(bidder.getPassword());
        bidderUpdate.setName(bidder.getName());
        bidderUpdate.setLastname(bidder.getLastname());
        bidderUpdate.setRoles(bidder.getRoles());
        bidderUpdate.setOffers(bidder.getOffers());
        bidderUpdate.setScore(bidder.getScore());
        bidderUpdate.setComments(bidder.getComments());
        bidderRepository.save(bidderUpdate);
        return bidderUpdate;
    }
    public List<Bidder> getAll(){
        return bidderRepository.findAll();
    }
    public Bidder getById(String id){
        return bidderRepository.getBidderById(id);
    }
}
