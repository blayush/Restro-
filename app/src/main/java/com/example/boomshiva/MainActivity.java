package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView skiptextView;
    public void gotoRegisterFun(View view){
        Intent intent=new Intent(MainActivity.this,SignupActivity.class);
        startActivity(intent);
    }
    public void gotoLoginFun(View view){
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        skiptextView=findViewById(R.id.skiptextView);
         database = FirebaseDatabase.getInstance("https://boomshiva-9a7eb-default-rtdb.firebaseio.com/");
        myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        myRef.setValue("Hello, Firebase!");
        skiptextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FoodActivity.class);
                startActivity(intent);
            }
        });
    }
    }
