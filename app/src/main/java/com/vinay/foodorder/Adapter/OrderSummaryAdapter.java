package com.vinay.foodorder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vinay.foodorder.DatabaseHandler;
import com.vinay.foodorder.Models.OrderDetail;
import com.vinay.foodorder.R;
import com.vinay.foodorder.databinding.SampleOrdersummaryBinding;
import java.util.ArrayList;
public class OrderSummaryAdapter extends RecyclerView.Adapter<OrderSummaryAdapter.viewHolder>
{
    ArrayList<OrderDetail> list;
    Context context;

    public OrderSummaryAdapter(ArrayList<OrderDetail> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.sample_ordersummary,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        OrderDetail detail=list.get(position);
        holder.binding.itemimage.setImageResource(detail.getImage());
        holder.binding.orderid.setText(detail.getId()+"");
        holder.binding.itemname.setText(detail.getFooadname());
        holder.binding.itemprice.setText(detail.getPrice()+"");
        holder.binding.quantity.setText(detail.getQuantity()+"");
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DatabaseHandler helper=new DatabaseHandler(context);
                if(helper.deleteorder(detail.getId())>0)
                {
                    Toast.makeText(context, "Item deleted successfully", Toast.LENGTH_SHORT).show();
                    return true;

                }
                else
                {
                    return false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        SampleOrdersummaryBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding=SampleOrdersummaryBinding.bind(itemView);
        }
    }
}