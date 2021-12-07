package com.examplespring.pruebamvc.service;

import com.examplespring.pruebamvc.dto.ApplicantDTO;
import com.examplespring.pruebamvc.dto.BidderDTO;
import com.examplespring.pruebamvc.exception.SystemLoginException;
import com.examplespring.pruebamvc.model.CreateOffer;
import com.examplespring.pruebamvc.model.Offer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

@Service
public class OfferService {
    private final String URL = "http://localhost:8088/api";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private HttpClient httpClient = HttpClients.createDefault();

    public ArrayList<Offer> findAll() throws IOException {
        HttpGet request = new HttpGet(URL+"/OfferController/");
        HttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());


        Type listType = new TypeToken<ArrayList<Offer>>() {}.getType();
        ArrayList<Offer> offers = new Gson().fromJson(result, listType);

        return offers;
    }


    public String saveOffer(CreateOffer offer) throws IOException {
        Offer offer_request = new Offer();
            offer_request.setDescription(offer.getDescription());
        offer_request.setZone(offer.getZone());
        offer_request.setPostalCode(offer.getPostalCode());

        offer_request.setBidderId("string");
        offer_request.setDate(new Date());
        offer_request.setRequestId("string");
        offer_request.setPrice(4500);



        HttpPost request = new HttpPost(URL+"/OfferController/");
        request.addHeader("content-type", "application/json");
        request.setEntity(new StringEntity(objectMapper.writeValueAsString(offer_request)));
        HttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }
}
