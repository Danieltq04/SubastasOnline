package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.OfferRequest;
import com.ajsw.microdb.model.Offer;
import com.ajsw.microdb.service.OfferService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/OfferController")
@CrossOrigin("*")
@Api(tags = "Offer")
public class OfferController {
    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping(value = "/")
    public List<Offer> getAll(){
        return offerService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Offer get(@PathVariable String id){
        return offerService.getById(id);
    }
    @PostMapping(value = "/")
    public Offer save(@RequestBody OfferRequest offerRequest){
        return offerService.save(offerRequest);
    }
    @DeleteMapping(value = "/{id}")
    public Offer delete(@PathVariable String id){
        return offerService.delete(id);
    }
    @PutMapping(value = "/")
    public Offer update(@RequestBody Offer offer){
        return offerService.update(offer);
    }

}
