package com.example.diamondvault.ui.main.ui.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.diamondvault.R;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    public static int ADD_PRODUCT_REQUEST_CODE= 11;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textViewWelcome = root.findViewById(R.id.text_welcome);
        final TextView textViewMarketPrices = root.findViewById(R.id.text_market_prices);
        final Button showReportBtn = root.findViewById(R.id.show_report_btn);
        final Button addProductBtn = root.findViewById(R.id.add_product_btn);

        dashboardViewModel.getWelcomeText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewWelcome.setText(s);
            }
        });
        dashboardViewModel.getMetalPricesText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textViewMarketPrices.setText(s);
            }
        });

        // Set an onClickListener for the showReportBtn
        showReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show the report dialog when the button is clicked
                showReportDialog();
            }
        });

        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddProductActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    // Function to show the report dialog
    private void showReportDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Sale Report"); // Set your title here
        dashboardViewModel.getReport().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                builder.setMessage(s);
            }
        });


        // Set a button for the positive action (e.g., OK)
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // You can handle the OK button click if needed
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}