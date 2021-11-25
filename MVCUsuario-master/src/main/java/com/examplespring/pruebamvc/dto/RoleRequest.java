package com.examplespring.pruebamvc.dto;

public class RoleRequest {
    private String role;

    public RoleRequest() {
    }

    public RoleRequest(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
