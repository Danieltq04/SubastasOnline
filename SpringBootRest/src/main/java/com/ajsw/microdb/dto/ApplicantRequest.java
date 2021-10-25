package com.ajsw.microdb.dto;

import com.ajsw.microdb.model.Request;
import com.ajsw.microdb.model.Role;
import java.util.List;
import java.util.Set;

public class ApplicantRequest {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Set<Role> roles;
    private List<Request> requests;
    private int score;

    public ApplicantRequest() {
    }

    public ApplicantRequest(String email, String password, String name, String lastname, Set<Role> roles, List<Request> requests, int score) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.roles = roles;
        this.requests = requests;
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

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
