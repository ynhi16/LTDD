package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

public class wishlist extends AppCompatActivity {
    FrameLayout nut1, nut2, nut3, nut4, fr_cart;
    Button btn_add_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wishlist);
        nut1 = (FrameLayout) findViewById(R.id.item1);
        nut2 = (FrameLayout) findViewById(R.id.item2);
        nut3 = (FrameLayout) findViewById(R.id.item3);
        nut4 = (FrameLayout) findViewById(R.id.item4);
        fr_cart = (FrameLayout) findViewById(R.id.fr1);
        btn_add_all = (Button) findViewById(R.id.add_wl);
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wishlist.this, wishlist.class);
                startActivity(intent);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wishlist.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wishlist.this, Cart1.class);
                startActivity(intent);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wishlist.this, User.class);
                startActivity(intent);
            }
        });
        fr_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wishlist.this, Cart2.class);
                startActivity(intent);
            }
        });
        btn_add_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wishlist.this, Cart2.class);
                startActivity(intent);
            }
        });
    }
}