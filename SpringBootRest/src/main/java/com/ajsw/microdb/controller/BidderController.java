package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.BidderRequest;
import com.ajsw.microdb.model.Bidder;
import com.ajsw.microdb.service.BidderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/BidderController")
@CrossOrigin("*")
@Api(tags = "Bidder")
public class BidderController {
    private final BidderService bidderService;

    @Autowired
    public BidderController(BidderService bidderService) {
        this.bidderService = bidderService;
    }

    @GetMapping(value = "/")
    public List<Bidder> getAll(){
        return bidderService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Bidder get(@PathVariable String id){
        return bidderService.getById(id);
    }
    @PostMapping(value = "/")
    public Bidder save(@RequestBody BidderRequest bidderRequest){
        return bidderService.save(bidderRequest);
    }
    @DeleteMapping(value = "/{id}")
    public Bidder delete(@PathVariable String id){
        return bidderService.delete(id);
    }
    @PutMapping(value = "/")
    public Bidder update(@RequestBody Bidder bidder){
        return bidderService.update(bidder);
    }

}
