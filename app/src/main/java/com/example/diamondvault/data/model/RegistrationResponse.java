package com.example.diamondvault.data.model;

public class RegistrationResponse {
    private Admin admin;
    private String token;
    private String error;

    public String getError() {
        return error;
    }
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
