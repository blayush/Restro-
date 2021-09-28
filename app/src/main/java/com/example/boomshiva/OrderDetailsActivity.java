package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.boomshiva.databinding.ActivityOrderDetailsBinding;

public class OrderDetailsActivity extends AppCompatActivity {
    ActivityOrderDetailsBinding activityOrderDetailsBinding;
    int quant;
    int totalPrice;
    public void priceUpdateFun(int quant){
        totalPrice = Integer.parseInt(activityOrderDetailsBinding.price.getText().toString());

        totalPrice = totalPrice * quant;


        activityOrderDetailsBinding.price.setText(String.format("%d", totalPrice));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderDetailsBinding = ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityOrderDetailsBinding.getRoot());
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        int image = getIntent().getIntExtra("image", 0);
        String description = getIntent().getStringExtra("desc");
        String name = getIntent().getStringExtra("name");

        activityOrderDetailsBinding.foodImage.setImageResource(image);
        activityOrderDetailsBinding.foodName.setText(name);
        activityOrderDetailsBinding.price.setText("Rs. " + (String.format("%d", price)));
        activityOrderDetailsBinding.descTextView.setText(description);
        activityOrderDetailsBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quant = Integer.parseInt(activityOrderDetailsBinding.quantityTextView.getText().toString());
                if (quant < 10) quant++;
                activityOrderDetailsBinding.quantityTextView.setText(String.format("%d", quant));
                priceUpdateFun(quant);

            }
        });
        activityOrderDetailsBinding.subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quant = Integer.parseInt(activityOrderDetailsBinding.quantityTextView.getText().toString());
                if (quant > 1) quant--;
                activityOrderDetailsBinding.quantityTextView.setText(String.format("%d", quant));
                priceUpdateFun(quant);
            }
        });

        DBHelper helper = new DBHelper(this);
        activityOrderDetailsBinding.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertOrder(activityOrderDetailsBinding.nameeditText.getText().toString(), activityOrderDetailsBinding.editTextPhone.getText().toString(), price, image, description, name, Integer.parseInt(activityOrderDetailsBinding.quantityTextView.getText().toString()));
                if (isInserted)
                    Toast.makeText(OrderDetailsActivity.this, "Data Success", Toast.LENGTH_SHORT).show();

                else Toast.makeText(OrderDetailsActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}