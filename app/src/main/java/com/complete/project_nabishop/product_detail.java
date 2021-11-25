package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class product_detail extends AppCompatActivity {
    Button add_cart;
    FrameLayout nut1, nut2, nut3, nut4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_product_detail);

        add_cart = (Button) findViewById(R.id.btn_add_cart);
        nut1 = (FrameLayout) findViewById(R.id.item1);
        nut2 = (FrameLayout) findViewById(R.id.item2);
        nut3 = (FrameLayout) findViewById(R.id.item3);
        nut4 = (FrameLayout) findViewById(R.id.item4);
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_detail.this, wishlist.class);
                startActivity(intent);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_detail.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_detail.this, Cart1.class);
                startActivity(intent);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_detail.this, User.class);
                startActivity(intent);
            }
        });
        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(product_detail.this, Cart2.class);
                startActivity(intent);
            }
        });
    }

}