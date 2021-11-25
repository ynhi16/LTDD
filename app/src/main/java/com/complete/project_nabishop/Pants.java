package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class Pants extends AppCompatActivity {
    FrameLayout img_back, nut1, nut2, nut3, nut4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pants);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        img_back = (FrameLayout) findViewById(R.id.img_back_pants);
        nut1 = (FrameLayout) findViewById(R.id.item1);
        nut2 = (FrameLayout) findViewById(R.id.item2);
        nut3 = (FrameLayout) findViewById(R.id.item3);
        nut4 = (FrameLayout) findViewById(R.id.item4);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pants.this, category.class);
                startActivity(intent);
            }
        });
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pants.this, wishlist.class);
                startActivity(intent);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pants.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pants.this, Cart1.class);
                startActivity(intent);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pants.this, User.class);
                startActivity(intent);
            }
        });
    }
}