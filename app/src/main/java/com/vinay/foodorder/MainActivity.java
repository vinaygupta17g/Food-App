package com.vinay.foodorder;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vinay.foodorder.Adapter.MainAdapter;
import com.vinay.foodorder.Adapter.OrderSummaryAdapter;
import com.vinay.foodorder.Models.MainModel;
import com.vinay.foodorder.Models.OrderDetail;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    OrderSummary fragment =new OrderSummary();
    ArrayList<MainModel> list=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView);
        list.add(new MainModel(R.drawable.food1,"Burger","10","Nice food"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","12","Nice food"));
        list.add(new MainModel(R.drawable.momos,"Momos","15","Nice food"));
        list.add(new MainModel(R.drawable.chowmein,"Chowmein","30","Nice food"));
        list.add(new MainModel(R.drawable.fries,"French Fries","50","Nice food"));
        list.add(new MainModel(R.drawable.idli,"Idli","70","Nice food"));
        list.add(new MainModel(R.drawable.dosa,"Dosa","90","Nice food"));
        list.add(new MainModel(R.drawable.noodles,"Noodles","65","Nice food"));
        MainAdapter adapter=new MainAdapter(list,this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_myorder,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fragment.show(getSupportFragmentManager(),fragment.getTag());
        return true;
    }
}