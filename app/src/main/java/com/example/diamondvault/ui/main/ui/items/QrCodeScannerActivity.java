package com.example.diamondvault.ui.main.ui.items;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.diamondvault.data.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrCodeScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1001;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);               // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();

        // Check for camera permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, start the camera
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        } else {
            // Request camera permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_REQUEST_CODE);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }


    @Override
    public void handleResult(com.google.zxing.Result rawResult) {
        // Handle the result (rawResult.getText())
        // You can pass the result to the search view or any other component in your app
        String qrCodeResult = rawResult.getText();
        // Set the result and finish the activity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("scannedResult", qrCodeResult);
        setResult(RESULT_OK, resultIntent);

        finish();  // Close the activity after handling the result
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Camera permission granted, start the camera
                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
            } else {
                // Camera permission denied, show a message or take appropriate action
                // For example, you can display a message to the user explaining why camera access is necessary.
            }
        }
    }

}
