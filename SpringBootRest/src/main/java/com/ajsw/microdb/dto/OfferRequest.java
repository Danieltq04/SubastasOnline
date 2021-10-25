package com.ajsw.microdb.dto;

import com.ajsw.microdb.model.Bidder;
import com.ajsw.microdb.model.Request;

import java.util.Date;

public class OfferRequest {
    private Bidder bidderId;
    private Request request;
    private String description;
    private double price;
    private Date date;

    public OfferRequest() {
    }

    public OfferRequest(Bidder bidderId, Request request, String description, double price, Date date) {
        this.bidderId = bidderId;
        this.request = request;
        this.description = description;
        this.price = price;
        this.date = date;
    }

    public Bidder getBidderId() {
        return bidderId;
    }

    public void setBidderId(Bidder bidderId) {
        this.bidderId = bidderId;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
