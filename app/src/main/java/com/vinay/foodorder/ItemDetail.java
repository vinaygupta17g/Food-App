package com.vinay.foodorder;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.vinay.foodorder.databinding.ActivityItemDetailBinding;
public class ItemDetail extends AppCompatActivity {
    ActivityItemDetailBinding binding;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding=ActivityItemDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent=getIntent();

        String foodname=intent.getStringExtra("foodname");
        String fooddescription=intent.getStringExtra("fooddescription");
        int image=intent.getIntExtra("foodimage",0);
        binding.image.setImageResource(image);
        binding.foodname.setText(intent.getStringExtra("name"));
        binding.fooddescription.setText(intent.getStringExtra("description"));
        binding.price.setText(intent.getStringExtra("price"));
        final int price1=Integer.parseInt(binding.price.getText().toString());
        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity=Integer.parseInt(binding.quantity.getText().toString());
                int price=Integer.parseInt(binding.price.getText().toString());
                quantity+=1;
                price+=price1;
                binding.quantity.setText(quantity+"");
                binding.price.setText(price+"");
            }
        });
        binding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity=Integer.parseInt(binding.quantity.getText().toString());
                int price=Integer.parseInt(binding.price.getText().toString());
                if(price>price1&&quantity>1)
                {
                    quantity-=1;
                    price-=price1;
                    binding.quantity.setText(quantity+"");
                    binding.price.setText(price+"");
                }
            }
        });
        binding.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.name.getText().toString();
                String mobile=binding.mobile.getText().toString();
                String foodname=binding.foodname.getText().toString();
                int foodprice=Integer.parseInt(binding.price.getText().toString());
                String description=binding.foodname.getText().toString();
                int quantity=Integer.parseInt(binding.quantity.getText().toString());
                if (name.isEmpty())
                    binding.name.setError("");
                else if (mobile.isEmpty())
                    binding.mobile.setError("");
                else
                {
                    DatabaseHandler handler=new DatabaseHandler(ItemDetail.this);
                    boolean isinserted=handler.orderinsert(image,foodname,foodprice,fooddescription,name,mobile,quantity);
                    if (isinserted)
                    {
                        OrderSummary fragment=new OrderSummary();
                        fragment.show(getSupportFragmentManager(),fragment.getTag());
                        Toast.makeText(ItemDetail.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(ItemDetail.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}