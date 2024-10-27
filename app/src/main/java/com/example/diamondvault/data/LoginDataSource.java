package com.example.diamondvault.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.diamondvault.R;
import com.example.diamondvault.data.model.Admin;
import com.example.diamondvault.data.model.LoginRequest;
import com.example.diamondvault.data.model.LoginResponse;
import com.example.diamondvault.data.network.ApiService;
import com.example.diamondvault.data.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private ApiService apiService;
    private Context context;
    public LoginDataSource(Context context){
        this.context = context;
        apiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
    }
    public void login(String username, String password, ILoginResponse callback) {
        LoginRequest request = new LoginRequest(username, password);
        Call<LoginResponse> call = apiService.login(request);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    // After a successful login, save the token to SharedPreferences
                    saveTokenToSharedPreferences(loginResponse.getToken());
                    callback.onResponse(loginResponse);
                } else {
                    callback.onFailure(new Throwable("Error logging in"));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t)  {

                callback.onFailure(t);
            }

        });
    }

    private void saveTokenToSharedPreferences(String token) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_info_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("admin_token", token);
        editor.apply();
    }

    public void logout() {
        // TODO: revoke authentication
    }
}