package com.example.diamondvault.ui.main.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.provider.MediaStore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diamondvault.R;
import com.example.diamondvault.data.model.ApiResponse;
import com.example.diamondvault.data.model.Product;
import com.example.diamondvault.data.network.ApiService;
import com.example.diamondvault.data.network.RetrofitClientInstance;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddProductActivity extends AppCompatActivity {

    private EditText editTitle, editDescription, editPrice, editQuantity,editSku;
    private Spinner categorySpinner, metalTypeSpinner, sizeSpinner;
    private Button addBtn;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        apiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);

        // Enable the Up button (back arrow) in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize UI components
        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editPrice = findViewById(R.id.editPrice);
        editQuantity = findViewById(R.id.editQuantity);
        editSku = findViewById(R.id.editSKU);

        categorySpinner = findViewById(R.id.categorySpinner);
        metalTypeSpinner = findViewById(R.id.metalTypeSpinner);
        sizeSpinner = findViewById(R.id.sizeSpinner);

        addBtn = findViewById(R.id.submit_btn);

        // Populate Spinners with data
        populateCategorySpinner();
        populateMetalTypeSpinner();
        populateSizeSpinner();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
    }

    // Populate the category Spinner
    private void populateCategorySpinner() {
        String[] categories = {"Necklaces", "Rings", "Bracelets"};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
    }

    // Populate the metal type Spinner
    private void populateMetalTypeSpinner() {
        String[] metalTypes = {"10K Gold", "14K Gold", "18K Gold","10K Silver","14K Silver","18K Silver"};
        ArrayAdapter<String> metalTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, metalTypes);
        metalTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metalTypeSpinner.setAdapter(metalTypeAdapter);
    }

    // Populate the size Spinner
    private void populateSizeSpinner() {
        String[] sizes = {"3", "3.5", "4","4.5","5","5.5","6","6.5","7","7.5","8","8.5","9","9.5","10"};
        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizes);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeAdapter);
    }

    // Handle the click event for the "Add Product" button
    public void addProduct() {
        // Retrieve data from UI components
        String title = editTitle.getText().toString();
        String sku = editSku.getText().toString();
        String description = editDescription.getText().toString();
        String category = categorySpinner.getSelectedItem().toString();
        String metalType = metalTypeSpinner.getSelectedItem().toString();
        String size = sizeSpinner.getSelectedItem().toString();
        String price = (editPrice.getText().toString());
        String quantity = (editQuantity.getText().toString());

        // Create a Product object with the retrieved data
        Product product = new Product(title,sku,category,metalType,price,size,description,quantity);
        Call<ApiResponse> call = apiService.addProduct(product);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                if (response.isSuccessful()) {
                    // Product added successfully
                    ApiResponse apiResponse = response.body();
                    Toast.makeText(getApplicationContext(), apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000); // 2000 milliseconds (2 seconds)

                } else if (response.code() == 422) {
                    // Handle 422 (Unprocessable Entity) - Validation error
                    ApiResponse apiError = null;
                    if (response.errorBody() != null) {
                        try {
                            // Parse the error response
                            apiError = new Gson().fromJson(response.errorBody().string(), ApiResponse.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (apiError != null) {
                        // Handle validation errors
                        String errorMessage = apiError.getMessage();
                        // Access specific field errors if needed: apiError.getErrors()
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Something is wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle failure
                Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
