package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.airbnb.lottie.L;
import com.example.boomshiva.Adapters.FoodAdapter;
import com.example.boomshiva.Models.MainModel;
import com.example.boomshiva.databinding.ActivityFoodBinding;
import com.example.boomshiva.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    ActivityFoodBinding binding;
    //RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        binding=ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel>list=new ArrayList<>();
        list.add(new MainModel(R.drawable.handipaneer,"Handi Paneer","139","Delicious and creamy gravy cooked in a handi. A Handi is an Indian Style Pot"));
        list.add(new MainModel(R.drawable.shahipaneer,"Shahi Paneer","149"," Fresh, unmelting cheese is married with a creamy gravy. “Shahi” means “royalty,” and I can promise this dish is fit for a King!"));
        list.add(new MainModel(R.drawable.paneerroll,"Paneer Roll","79","The tongue tickling spicy masala of grated paneer wrapped in paratha is a treat to taste buds at anytime anywhere"));
        list.add(new MainModel(R.drawable.vegroll,"Veg Roll","39","Delicious veggie wrapped parantha with spicy addons , must have Fast Food"));
        list.add(new MainModel(R.drawable.malaikofta,"Malai Kofta","189","Delicious dish of fried balls of potato and paneer in a rich and creamy mild gravy made with sweet onions and tomatoes"));


        FoodAdapter adapter=new FoodAdapter(list,this);
        binding.recylerview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(linearLayoutManager);

    }
}