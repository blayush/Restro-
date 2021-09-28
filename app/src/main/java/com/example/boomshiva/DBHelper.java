package com.example.boomshiva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.boomshiva.Models.OrderPageModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "description text," +
                        "foodname text," +
                        "quantity int)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exist orders");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodname,int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodname);
        values.put("quantity",quantity);
        long id = database.insert("orders", null, values);
        return id > 0;
    }
    public ArrayList<OrderPageModel>getOrders(){
        ArrayList<OrderPageModel>orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor= database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderPageModel model=new OrderPageModel();
                model.setOrderImg(cursor.getInt(2));
                model.setOrderItemName(cursor.getString(1));
                model.setPrice(cursor.getInt(3)+"");
                model.setOrderNumber(cursor.getInt(0)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
}
