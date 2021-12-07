package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.complete.project_nabishop.controller.APIService;
import com.complete.project_nabishop.controller.Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dress extends AppCompatActivity {
    FrameLayout back,nut1, nut2, nut3, nut4;
    private RecyclerView recyclerView;
    APIService apiService;
    private SPMain_Adapter mAdapter;
    List<SanPham_Main> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        back = (FrameLayout) findViewById(R.id.img_back_dress);
        nut1 = (FrameLayout) findViewById(R.id.item1);
        nut2 = (FrameLayout) findViewById(R.id.item2);
        nut3 = (FrameLayout) findViewById(R.id.item3);
        nut4 = (FrameLayout) findViewById(R.id.item4);
        recyclerView = findViewById(R.id.ds_sp);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        apiService= Client.getAPIService();
        listar();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dress.this, category.class);
                startActivity(intent);
            }
        });
        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dress.this, wishlist.class);
                startActivity(intent);
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dress.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dress.this, Cart1.class);
                startActivity(intent);
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dress.this, User.class);
                startActivity(intent);
            }
        });
    }
    public void listar(){
        Call<List<SanPham_Main>> call=apiService.getDress();
        call.enqueue(new Callback<List<SanPham_Main>>() {
            @Override
            public void onResponse(Call<List<SanPham_Main>> call, Response<List<SanPham_Main>> response) {
                if(response.code()!=200){
                    return;
                }
                List<SanPham_Main>data= response.body();
                for (SanPham_Main sp:data){
                    list.add(sp);
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