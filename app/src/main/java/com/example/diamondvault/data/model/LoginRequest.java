package com.example.diamondvault.data.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("emailAddress")
    private String username;
    @SerializedName("password")
    private String password;
    // Constructors, getters, and setters

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
