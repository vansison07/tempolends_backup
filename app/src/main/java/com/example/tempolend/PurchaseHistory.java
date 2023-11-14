package com.example.tempolend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PurchaseHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
    }

    public void onBack(View v) {
        startActivity(new Intent(PurchaseHistory.this, Profile.class));
    }
}