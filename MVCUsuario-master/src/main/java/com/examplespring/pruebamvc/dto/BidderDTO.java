package com.examplespring.pruebamvc.dto;

import com.examplespring.pruebamvc.model.Role;

import java.util.List;
import java.util.Set;

public class BidderDTO {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Set<Role> roles;
    private int score;

    public BidderDTO() {
    }

    public BidderDTO(String email, String password, String name, String lastname, Set<Role> roles, int score) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.roles = roles;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
