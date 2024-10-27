package com.example.diamondvault.ui.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diamondvault.R;
import com.example.diamondvault.data.model.Admin;
import com.example.diamondvault.data.model.RegistrationResponse;
import com.example.diamondvault.data.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private EditText phoneNumberEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Enable the Up button (back arrow) in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        nameEditText = findViewById(R.id.editTextName);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        phoneNumberEditText = findViewById(R.id.editTextPhoneNumber);
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword);

        registerButton = findViewById(R.id.buttonRegister);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input from EditText fields
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Check if passwords match
                if (!password.equals(confirmPassword)) {
                    // Passwords do not match, display a pop-up dialog
                    showPasswordMismatchDialog();
                } else {
                    // Passwords match, proceed with registration process
                    // Use Retrofit or another library to send a POST request to your Laravel API with user data
                    // Handle the API response and display a message to the user

                    // Create a Retrofit instance
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(getResources().getString(R.string.retrofit_base_url))
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                        // Create an instance of your ApiService
                    ApiService apiService = retrofit.create(ApiService.class);

                    // Create a Admin object with the registration data
                    Admin admin = new Admin(name,email,phoneNumber,password);

                    // Make the API request
                    Call<RegistrationResponse> call = apiService.registerUser(admin);
                    call.enqueue(new Callback<RegistrationResponse>() {

                        @Override
                        public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                            if (response.isSuccessful()) {
                                RegistrationResponse registrationResponse = response.body();
                                Admin admin = registrationResponse.getAdmin();
                                String token = registrationResponse.getToken();
                                Log.d("RegistrationActivity", String.valueOf(admin));
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(RegistrationActivity.this, "Successfully register an user", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                // Handle the case where the request was not successful (e.g., display an error message)
                                RegistrationResponse registrationResponse = response.body();
                                String error = registrationResponse.getError();
                                Log.d("RegistrationActivity", "failed");
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(RegistrationActivity.this, error, Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                            // Handle the case where the request failed (e.g., display an error message)
                            Log.d("RegistrationActivity", "Request failed", t);

                            // Show a toast message with the error
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(RegistrationActivity.this, "Something is wrong with your network", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });

                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Handle the Up button click (navigate back)
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showPasswordMismatchDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password Mismatch");
        builder.setMessage("The passwords you entered do not match.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
