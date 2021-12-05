package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;


public class category extends AppCompatActivity {
    FrameLayout ao,quan,vay,giay, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category);
        ao = (FrameLayout) findViewById(R.id.shirt);
        quan = (FrameLayout) findViewById(R.id.pants);
        vay = (FrameLayout) findViewById(R.id.dress);
        giay = (FrameLayout) findViewById(R.id.shoes);
        back = (FrameLayout) findViewById(R.id.btn_back_category);
        ao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this,Shirt.class);
                startActivity(intent);
            }
        });
        quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this,Pants.class);
                startActivity(intent);
            }
        });
        vay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this,Dress.class);
                startActivity(intent);
            }
        });
        giay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this,Shoes.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}