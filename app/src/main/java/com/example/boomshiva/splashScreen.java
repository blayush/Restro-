package com.example.boomshiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Thread td=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1900);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(splashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();
    }
}