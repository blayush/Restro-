package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.boomshiva.Models.OrderPageModel;
import com.example.boomshiva.databinding.ActivityOrderPageBinding;

import java.util.ArrayList;

public class OrderPageActivity extends AppCompatActivity {
    ActivityOrderPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityOrderPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrderPageModel>list=new ArrayList<>();
        list.add(new OrderPageModel((R.drawable.paneerroll),"Paneer Roll","79","301"));
        list.add(new OrderPageModel((R.drawable.malaikofta),"Malai Kofta","189","303"));
        list.add(new OrderPageModel((R.drawable.vegroll),"Veg Roll","39","305"));
        list.add(new OrderPageModel((R.drawable.shahipaneer),"Shahi Paneer","159","302"));
        list.add(new OrderPageModel((R.drawable.paneerroll),"Paneer Roll","79","301"));
        list.add(new OrderPageModel((R.drawable.malaikofta),"Malai Kofta","189","303"));
        list.add(new OrderPageModel((R.drawable.vegroll),"Veg Roll","39","305"));
        list.add(new OrderPageModel((R.drawable.shahipaneer),"Shahi Paneer","159","302"));


    }
}