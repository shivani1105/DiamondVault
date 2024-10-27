package com.example.diamondvault.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static String API_BASE_URL = "http://45.79.3.250:8080";
    private static Retrofit retrofit;
    private static Gson gson;

    public static Retrofit getRetrofitInstance(){

        if(retrofit==null){
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Authorization", "Bearer " + "48|WMhMKCghXdynHuu6kAc33NVvWRKF0f7yh3A5P6Zub1b12823")
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();
            gson = new GsonBuilder().setLenient().create();

            retrofit = new Retrofit.Builder().client(client).baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
