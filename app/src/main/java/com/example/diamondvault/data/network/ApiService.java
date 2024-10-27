package com.example.diamondvault.data.network;

import com.example.diamondvault.data.model.Admin;
import com.example.diamondvault.data.model.ApiResponse;
import com.example.diamondvault.data.model.LoginRequest;
import com.example.diamondvault.data.model.LoginResponse;
import com.example.diamondvault.data.model.MetalPricesResponse;
import com.example.diamondvault.data.model.Product;
import com.example.diamondvault.data.model.RegistrationResponse;
import com.example.diamondvault.data.model.ReportResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("/api/register")
    Call<RegistrationResponse> registerUser(@Body Admin admin);
    @POST("/api/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("/api/getMetalPrices")
    Call<MetalPricesResponse> getMetalPrices(@Header("Authorization") String token);

    @POST("/api/getTransactionReport")
    Call<ReportResponse> getReport(@Header("Authorization") String token);

    @POST("/api/addProduct")
    Call<ApiResponse> addProduct(@Body Product product);
    @POST("/api/listProducts")
    Call<List<Product>> getProducts();
    @POST("/api/searchProducts")
    Call<List<Product>> searhProducts(@Query("query") String query);
}
