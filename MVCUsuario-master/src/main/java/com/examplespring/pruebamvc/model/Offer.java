package com.examplespring.pruebamvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

public class Offer {
    private String bidderId;
    private String request;
    private String description;
    private String zone;
    private String postalCode;
    private double price;
    private Date date;

    public Offer() {
    }

    public Offer(String bidderId, String requestId, String description, String zone, String postalCode, double price, Date date) {
        this.bidderId = bidderId;
        this.request = requestId;
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
        return request;
    }

    public void setRequestId(String requestId) {
        this.request = requestId;
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
