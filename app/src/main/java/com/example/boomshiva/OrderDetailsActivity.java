package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.boomshiva.databinding.ActivityOrderDetailsBinding;

public class OrderDetailsActivity extends AppCompatActivity {
    ActivityOrderDetailsBinding activityOrderDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderDetailsBinding=ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityOrderDetailsBinding.getRoot());



    }
}