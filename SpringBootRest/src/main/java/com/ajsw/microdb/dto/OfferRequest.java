package com.ajsw.microdb.dto;

import com.ajsw.microdb.model.Bidder;
import com.ajsw.microdb.model.Request;

import java.util.Date;

public class OfferRequest {
    private String bidderId;
    private String requestId;
    private String description;
    private String zone;
    private String postalCode;
    private double price;
    private Date date;

    public OfferRequest() {
    }

    public OfferRequest(String bidderId, String requestId, String description, String zone, String postalCode, double price, Date date) {
        this.bidderId = bidderId;
        this.requestId = requestId;
        this.description = description;
        this.zone = zone;
        this.postalCode = postalCode;
        this.price = price;
        this.date = date;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
