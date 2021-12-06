package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.OfferRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Offer;
import com.ajsw.microdb.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }
    public Offer save(OfferRequest offerRequest){
        Offer offer = new Offer();
        offer.setBidderId(offerRequest.getBidderId());
        offer.setRequestId(offerRequest.getRequestId());
        offer.setDescription(offerRequest.getDescription());
        offer.setZone(offerRequest.getZone());
        offer.setPostalCode(offerRequest.getPostalCode());
        offer.setPrice(offerRequest.getPrice());
        offer.setDate(offerRequest.getDate());
        return offerRepository.save(offer);
    }
    public Offer delete(String id){
        Offer offer = offerRepository.getOfferById(id);
        if(offer == null){
            throw new SystemLoginException("");
        }
        return offerRepository.deleteOfferById(id);
    }
    public Offer update(Offer offer){
        Offer offerUpdate = offerRepository.getOfferById(offer.getId());
        offerUpdate.setBidderId(offer.getBidderId());
        offerUpdate.setRequestId(offer.getRequestId());
        offerUpdate.setDescription(offer.getDescription());
        offerUpdate.setZone(offer.getZone());
        offerUpdate.setPostalCode(offer.getPostalCode());
        offerUpdate.setPrice(offer.getPrice());
        offerUpdate.setDate(offer.getDate());
        offerRepository.save(offerUpdate);
        return offerUpdate;
    }
    public List<Offer> getAll(){
        return offerRepository.findAll();
    }
    public Offer getById(String id){
        return offerRepository.getOfferById(id);
    }
    public List<Offer> getByPostalCode(String id){

        return offerRepository.getOffersByPostalCode(id);
    }

}
