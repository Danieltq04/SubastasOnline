package com.ajsw.microdb.dto;

import com.ajsw.microdb.model.Comment;
import com.ajsw.microdb.model.Offer;
import com.ajsw.microdb.model.Role;
import java.util.List;
import java.util.Set;

public class BidderRequest {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Set<Role> roles;
    private List<Offer> offers;
    private int score;
    private List<Comment> comments;

    public BidderRequest() {
    }

    public BidderRequest(String email, String password, String name, String lastname, Set<Role> roles, List<Offer> offers, int score, List<Comment> comments) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.roles = roles;
        this.offers = offers;
        this.score = score;
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
