package com.example.boomshiva.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boomshiva.Models.OrderPageModel;
import com.example.boomshiva.R;

import java.util.ArrayList;

public class OrderPageAdapter extends RecyclerView.Adapter<OrderPageAdapter.viewHolder> {
    ArrayList <OrderPageModel>list;
    Context context;

    public OrderPageAdapter(ArrayList<OrderPageModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate((R.layout))
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderPageAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView orderImg;
        TextView orderItemName,orderNumber,price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImg=itemView.findViewById(R.id.OrderimageView);
            orderItemName=itemView.findViewById(R.id.OrderNameTextView);
            orderNumber=itemView.findViewById(R.id.ordernumbeDataTextView);
            price=itemView.findViewById(R.id.priceDataTextView);

        }
    }
}
