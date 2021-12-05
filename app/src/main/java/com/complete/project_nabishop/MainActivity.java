package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewFlipper slide;
    FrameLayout danhmuc, nut1,nut2,nut3,nut4, tkiem;
    private RecyclerView recyclerView;
    private SPMain_Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        danhmuc = (FrameLayout) findViewById(R.id.fr_dm);
        slide = (ViewFlipper) findViewById(R.id.slide_anh);
        nut1 = (FrameLayout) findViewById(R.id.item1);
        nut2 = (FrameLayout) findViewById(R.id.item2);
        nut3 = (FrameLayout) findViewById(R.id.item3);
        nut4 = (FrameLayout) findViewById(R.id.item4);
        tkiem = (FrameLayout) findViewById(R.id.timkiem);

        recyclerView = findViewById(R.id.ds_sp);
        mAdapter = new SPMain_Adapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter.setData(getListSP());
        recyclerView.setAdapter(mAdapter);

        slide.setFlipInterval(3000);
        slide.setAutoStart(true);
        danhmuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, category.class);
                startActivity(intent);
            }
        });
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, wishlist.class);
                startActivity(intent);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cart1.class);
                startActivity(intent);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, User.class);
                startActivity(intent);
            }
        });
        tkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, search.class);
                startActivity(intent);
            }
        });
    }
    private List<SanPham_Main> getListSP(){
        List<SanPham_Main> list = new ArrayList<>();
        list.add(new SanPham_Main(R.drawable.anh1,"Girl trendy sweater","đ 310.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh2,"Balbina Blouse and Dress","đ 350.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh3,"Girl trendy sweater","đ 310.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh4,"Converse chuck taylor all star","đ 550.000","đ 470.000"));

        list.add(new SanPham_Main(R.drawable.anh1,"Girl trendy sweater","đ 310.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh2,"Balbina Blouse and Dress","đ 350.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh3,"Girl trendy sweater","đ 310.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh4,"Converse chuck taylor all star","đ 550.000","đ 470.000"));

        list.add(new SanPham_Main(R.drawable.anh1,"Girl trendy sweater","đ 310.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh2,"Balbina Blouse and Dress","đ 350.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh3,"Girl trendy sweater","đ 310.000","đ 470.000"));
        list.add(new SanPham_Main(R.drawable.anh4,"Converse chuck taylor all star","đ 550.000","đ 470.000"));
        return list;
    }
}

