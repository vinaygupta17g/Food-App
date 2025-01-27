package com.vinay.foodorder.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
                new AlertDialog.Builder(context).setTitle("Delete").setIcon(R.drawable.baseline_delete_24).setMessage("Are you sure you want to delete?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseHandler helper =new DatabaseHandler(view.getContext());
                        if(helper.deleteorder(detail.getId())<=0)
                            Toast.makeText(context, "Not deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(context, "Order deleted successfully", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                }).show();

                return false;
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