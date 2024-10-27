package com.example.diamondvault.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diamondvault.R;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText emailEditText;
    private Button sendResetLinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.editTextEmail);
        sendResetLinkButton = findViewById(R.id.buttonSendResetLink); // You can create this button in the XML layout.

        sendResetLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the email entered by the user
                String email = emailEditText.getText().toString();
                sendResetLinkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Implement the logic to send a password reset link to the provided email address.
                        // This can include making an API request to your backend server.

                        // Optionally, you can show a message to the user indicating that a reset link has been sent.
                    }
                });

            }
        });
    }
}
