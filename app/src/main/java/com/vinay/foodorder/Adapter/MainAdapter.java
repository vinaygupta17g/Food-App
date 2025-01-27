package com.vinay.foodorder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vinay.foodorder.ItemDetail;
import com.vinay.foodorder.Models.MainModel;
import com.vinay.foodorder.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder>
{

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        MainModel model=list.get(position);
        holder.foodImage.setImageResource(model.getFoodimage());
        holder.foodName.setText(model.getFoodname());
        holder.foodPrice.setText(model.getFoodPrice());
        holder.foodDescription.setText(model.getFooddescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ItemDetail.class);
                intent.putExtra("name",model.getFoodname());
                intent.putExtra("price",model.getFoodPrice());
                intent.putExtra("description",model.getFooddescription());
                intent.putExtra("foodimage",model.getFoodimage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        ImageView foodImage;
        TextView foodName,foodPrice,foodDescription;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.itemimage);
            foodName=itemView.findViewById(R.id.itemname);
            foodPrice=itemView.findViewById(R.id.itemprice);
            foodDescription=itemView.findViewById(R.id.itemdescription);
        }
    }

}
