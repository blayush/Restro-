package com.example.boomshiva.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boomshiva.Models.MainModel;
import com.example.boomshiva.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.viewholder>{
    ArrayList<MainModel>list;
    Context context;

    public FoodAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.viewholder holder, int position) {
        final MainModel model=list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView mainName,price,description;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.handiPaneer);
            mainName=itemView.findViewById(R.id.mainName);
            price=itemView.findViewById(R.id.handiPriceTextView);
            description=itemView.findViewById(R.id.descriptionTextView);
        }


    }
}
