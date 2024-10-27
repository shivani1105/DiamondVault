package com.example.diamondvault.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();

    public MainViewModel(){
        mLoginResultMutableData.postValue("Not logged in");

    }
    public void login(String email, String password){

    }
}
