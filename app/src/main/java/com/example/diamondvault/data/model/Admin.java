package com.example.diamondvault.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class Admin {

    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String password;

    public Admin(String name, String emailAddress, String phoneNumber, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}