package com.example.diamondvault.ui.main.ui.items;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diamondvault.R;
import com.example.diamondvault.data.model.Product;
import com.example.diamondvault.data.network.ApiService;
import com.example.diamondvault.data.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


public class ItemsFragment extends Fragment {
    private static final int QR_CODE_SCANNER_REQUEST_CODE = 1;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private SearchView searchView ;
    private ImageView cameraIcon;
    ApiService productService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_items, container, false);
        searchView = root.findViewById(R.id.searchView);
        cameraIcon = root.findViewById(R.id.cameraIcon);
        recyclerView = root.findViewById(R.id.items_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the adapter with an empty list
        productAdapter = new ProductAdapter(new ArrayList<>());
        recyclerView.setAdapter(productAdapter);

        // Make the Retrofit API call and update the adapter when the data is received
        productService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        Call<List<Product>> call = productService.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> productList = response.body();
                    productAdapter.setProductList(productList);
                } else {
                    // Handle API error
                    Log.e("ProductFragment", "API request failed");
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Handle network error
                Log.e("ProductFragment", "Network error", t);
            }
        });


        //Search items based on api
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform search when the user submits the query
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Update search results as the user types
                // You can optionally implement auto-suggestions here
                performSearch(newText);
                return true;
            }
        });



        // Set a click listener for the camera icon
        cameraIcon.setOnClickListener(v -> {
            startQRCodeScanner();
            // Handle the click (e.g., open the QR code scanner activity)
            // You can launch the QR code scanner activity or implement your logic here
        });
        return root;
    }


    private void performSearch(String query) {

        // Make the API call
        Call<List<Product>> call = productService.searhProducts(query);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> searchResults = response.body();
                    // Handle search results (update UI, etc.)
                    // Update RecyclerView with search results
                    productAdapter.setProductList(searchResults);
                } else {
                    // Handle error
                    Log.e("ProductFragment", "Search API request failed");
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Handle network errors or API call failure
                Log.e("ProductFragment", "Search API request failed", t);
            }
        });
    }


    private void startQRCodeScanner() {
        Intent intent = new Intent(getActivity(), QrCodeScannerActivity.class);
        startActivityForResult(intent, QR_CODE_SCANNER_REQUEST_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == QR_CODE_SCANNER_REQUEST_CODE && resultCode == RESULT_OK) {
            // Handle the scanned QR code result here
            String scannedResult = data.getStringExtra("scannedResult");
            // Do something with the result
            searchView.setQuery(scannedResult,true);
        }
    }
}