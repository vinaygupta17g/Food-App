package com.vinay.foodorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.vinay.foodorder.Models.OrderDetail;
import java.util.ArrayList;
public class DatabaseHandler extends SQLiteOpenHelper {
    final static String DB_NAME="foodorder.db";
    final static int DB_VERSION=1;
    public DatabaseHandler(@Nullable Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table foodorder"+"(id INTEGER PRIMARY KEY autoincrement,"+"foodimage int,"+"foodname text,"+"foodprice int,"+"fooddescription text,"+"name text,"+"mobile text,"+"quantity int)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if exists foodorder");
        onCreate(sqLiteDatabase);
    }
    public boolean orderinsert(int foodimage,String foodname,int foodprice,String fooddescription,String name,String mobile,int quantity)
    {
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("foodimage",foodimage);
        values.put("foodname",foodname);
        values.put("foodprice",foodprice);
        values.put("fooddescription",fooddescription);
        values.put("name",name);
        values.put("mobile",mobile);
        values.put("quantity",quantity);
        Long id=database.insert("foodorder",null,values);
        if(id<=0)
            return false;
        else
            return true;
    }
    public ArrayList<OrderDetail> getAllOrders()
    {
        SQLiteDatabase database=getWritableDatabase();
        ArrayList<OrderDetail> detail=new ArrayList<>();
        Cursor cursor=database.rawQuery("select * from foodorder",null);
        if (cursor.moveToFirst())
        {
            while(cursor.moveToNext())
            {
                OrderDetail detail1=new OrderDetail();
                detail1.setId(cursor.getInt(0));
                detail1.setImage(cursor.getInt(1));
                detail1.setFooadname(cursor.getString(2));
                detail1.setPrice(cursor.getInt(3));
                detail1.setFooddescription(cursor.getString(4));
                detail1.setName(cursor.getString(5));
                detail1.setMobile(cursor.getString(6));
                detail1.setQuantity(cursor.getInt(7));
                detail.add(detail1);
            }
        }
        cursor.close();
        database.close();
        return detail;
    }
    public int deleteorder(int id)
    {
        SQLiteDatabase database=getWritableDatabase();
        return database.delete("foodorder","id="+id,null);
    }
}
