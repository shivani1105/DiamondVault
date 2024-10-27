package com.example.diamondvault.ui.main.ui.dashboard;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.diamondvault.data.model.MetalPricesResponse;
import com.example.diamondvault.data.model.QuarterlyRevenue;
import com.example.diamondvault.data.model.ReportResponse;
import com.example.diamondvault.data.network.ApiService;
import com.example.diamondvault.data.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends AndroidViewModel {

    private MutableLiveData<String> mTextWelcome;
    private MutableLiveData<String> mTextPrices;
    private MutableLiveData<String> mReport;
    private SharedPreferences sharedPreferences;
    private ApiService apiService;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        apiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        mTextWelcome = new MutableLiveData<>();
        mTextWelcome.setValue("Welcome to Diamond Vault");
        sharedPreferences = application.getSharedPreferences("user_info_pref", Context.MODE_PRIVATE);

        mTextPrices = new MutableLiveData<>();
        mTextPrices.setValue("Fetching metal prices...");
        fetchPricesMessage();

        mReport = new MutableLiveData<>();
        mReport.setValue("Fetching...");
        fetchRevenues();
    }

    private void fetchPricesMessage() {
        Call<MetalPricesResponse> call = apiService.getMetalPrices(getAdminToken());
        call.enqueue(new Callback<MetalPricesResponse>() {
            @Override
            public void onResponse(Call<MetalPricesResponse> call, Response<MetalPricesResponse> response) {
                if (response.isSuccessful()) {
                    MetalPricesResponse data = response.body();
                    if (data != null) {
                        String goldPrice = data.getGold();
                        String silverPrice = data.getSilver();
                        //Got Api response for metal prices
                        String text = "Gold Price:"+goldPrice+" $/toz"
                                +"\nSilver Price:"+silverPrice+" $/toz";
                        mTextPrices.setValue(text);
                    }
                }
            }

            @Override
            public void onFailure(Call<MetalPricesResponse> call, Throwable t) {
                mTextPrices.setValue("Failed to fetch data, check your connection");
            }
        });
    }

    private void fetchRevenues() {
        Call<ReportResponse> call = apiService.getReport(getAdminToken());
        call.enqueue(new Callback<ReportResponse>() {
            @Override
            public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {
                if (response.isSuccessful()) {
                    ReportResponse data = response.body();
                    if (data != null) {
                        String message = formatRevenueData(data);
                        mReport.setValue(message);
                    }
                }
            }

            @Override
            public void onFailure(Call<ReportResponse> call, Throwable t) {

            }
        });

    }

    public String formatRevenueData(ReportResponse apiResponse) {
        StringBuilder formattedRevenue = new StringBuilder();

        // Iterate through quarterly revenue data
        for (QuarterlyRevenue quarterlyRevenue : apiResponse.getQuarterlyRevenue()) {
            formattedRevenue.append("Quarter: ").append(quarterlyRevenue.getQuarter()).append("\n");
            formattedRevenue.append("Start Date: ").append(quarterlyRevenue.getStartDate()).append("\n");
            formattedRevenue.append("End Date: ").append(quarterlyRevenue.getEndDate()).append("\n");
            formattedRevenue.append("Total Revenue: $").append(quarterlyRevenue.getTotalRevenue()).append("\n");
            formattedRevenue.append("Total Profit: $").append(quarterlyRevenue.getTotalProfit()).append("\n");
            formattedRevenue.append("\n");
        }

        // Add total sale information
        formattedRevenue.append("Total Sale: $").append(apiResponse.getTotalSale());

        return formattedRevenue.toString();
    }

    public String getAdminToken() {
        // Retrieve the admin token from SharedPreferences
        String adminToken =sharedPreferences.getString("admin_token", null);
        return "Bearer "+adminToken;
    }


    public LiveData<String> getWelcomeText() {
        return mTextWelcome;
    }

    public LiveData<String> getMetalPricesText() {
        return mTextPrices;
    }

    public LiveData<String> getReport() {
        return mReport;
    }
}