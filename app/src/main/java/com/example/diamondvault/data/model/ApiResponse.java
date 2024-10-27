package com.example.diamondvault.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ApiResponse {
    @SerializedName("message")
    private String message;
    @SerializedName("errors")
    private Map<String, List<String>> errors;

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
