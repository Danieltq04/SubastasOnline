package com.ajsw.microdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.Date;

@Document
public class Offer implements Serializable {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private Bidder bidderId;
    private Request request;
    private String description;
    private double price;
    private Date date;

    public Offer() {
    }

    public Offer(Bidder bidderId, Request request, String description, double price, Date date) {
        this.bidderId = bidderId;
        this.request = request;
        this.description = description;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
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
