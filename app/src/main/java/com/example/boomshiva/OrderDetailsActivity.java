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
        int price=Integer.parseInt(getIntent().getStringExtra("price"));
        int image=getIntent().getIntExtra("image",0);
        String description=getIntent().getStringExtra("desc");
        String name=getIntent().getStringExtra("name");

        activityOrderDetailsBinding.foodImage.setImageResource(image);
        activityOrderDetailsBinding.foodName.setText(name);
        activityOrderDetailsBinding.price.setText("Rs. "+(String.format("%d",price)));
        activityOrderDetailsBinding.descTextView.setText(description);
        bindin

    }
}