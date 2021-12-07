package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.complete.project_nabishop.controller.APIService;
import com.complete.project_nabishop.controller.Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ViewFlipper slide;
    FrameLayout danhmuc, nut1,nut2,nut3,nut4, tkiem;
    private RecyclerView recyclerView;
    List<SanPham_Main> list = new ArrayList<>();
    private SPMain_Adapter mAdapter;
    TextView tenshop;
    APIService apiService;
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
        tenshop = (TextView) findViewById(R.id.tenshop);
        recyclerView = findViewById(R.id.ds_sp);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        apiService= Client.getAPIService();
        listar();
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
    public void listar(){
        Call<List<SanPham_Main>> call=apiService.getSanPham();
        call.enqueue(new Callback<List<SanPham_Main>>() {
            @Override
            public void onResponse(Call<List<SanPham_Main>> call, Response<List<SanPham_Main>> response) {
                if(response.code()!=200){
                    return;
                }
                List<SanPham_Main>data= response.body();
                for (SanPham_Main mon:data){
                    list.add(mon);
                }
                PutDataIntoRecyclerView(data);
            }

            @Override
            public void onFailure(Call<List<SanPham_Main>> call, Throwable t) {

            }
        });
    }

    private void PutDataIntoRecyclerView(List<SanPham_Main> list) {
        mAdapter = new SPMain_Adapter(this,list);
        recyclerView.setLayoutManager(new GridLayoutManager(    this,2));
        recyclerView.setAdapter(mAdapter);
    }
}

