package com.complete.project_nabishop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cart2 extends AppCompatActivity {
    FrameLayout nut1, nut2, nut3, nut4;
    ImageView minus,plus;
    TextView number,total,tvPrice;
    Button btn;
    int numberOrder = 0, totalPrice, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        nut1 = (FrameLayout) findViewById(R.id.item1);
        nut2 = (FrameLayout) findViewById(R.id.item2);
        nut3 = (FrameLayout) findViewById(R.id.item3);
        nut4 = (FrameLayout) findViewById(R.id.item4);
        btn = (Button) findViewById(R.id.btn_buy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart2.this, Pay_Order.class);
                startActivity(intent);
            }
        });
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart2.this, wishlist.class);
                startActivity(intent);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart2.this, Cart2.class);
                startActivity(intent);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart2.this, User.class);
                startActivity(intent);
            }
        });
        initView();
        getBundle();

    }




    private void initView() {
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        number = findViewById(R.id.tv_number);
        total = findViewById(R.id.tv_total);
        tvPrice = findViewById(R.id.tv_price);

    }
    private void getBundle() {
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                number.setText(String.valueOf(numberOrder));

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                number.setText(String.valueOf(numberOrder));
            }
        });
    }

}