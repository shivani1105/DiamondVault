package com.example.diamondvault.data;


import com.example.diamondvault.data.model.LoginResponse;

public interface ILoginResponse{
    void onResponse(LoginResponse loginResponse);
    void onFailure(Throwable t);
}