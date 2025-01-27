package com.vinay.foodorder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.vinay.foodorder.Adapter.OrderSummaryAdapter;
import com.vinay.foodorder.Models.OrderDetail;
import com.vinay.foodorder.databinding.FragmentOrderSummeryBinding;

import java.util.ArrayList;

public class OrderSummary extends BottomSheetDialogFragment {
    FragmentOrderSummeryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentOrderSummeryBinding.inflate(inflater,container,false);

        DatabaseHandler helper=new DatabaseHandler(getContext());
        ArrayList<OrderDetail> list=helper.getAllOrders();

        OrderSummaryAdapter adapter =new OrderSummaryAdapter(list,getContext());
        binding.ordersummary.setAdapter(adapter);

        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        binding.ordersummary.setLayoutManager(manager);
        return binding.getRoot();
    }
}