package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.complete.project_nabishop.controller.APIService;
import com.complete.project_nabishop.controller.Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search extends AppCompatActivity {
    private Adapte_SanPham mAdapter;
    private EditText edt;
    private FrameLayout fr_back;
    private RecyclerView recyclerView;
    List<SanPham_Main> list = new ArrayList<>();
    APIService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);
        edt = (EditText) findViewById(R.id.edt_search);
        fr_back =(FrameLayout) findViewById(R.id.btn_back_search);
        recyclerView = findViewById(R.id.ds_sp);
        apiService= Client.getAPIService();
        listar();
        fr_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(search.this, MainActivity.class);
                startActivity(intent);
            }
        });
         edt.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             }

             @Override
             public void afterTextChanged(Editable editable) {
                 filter(editable.toString());
             }
         });
    }
    private void filter(String text){
        ArrayList<SanPham_Main> filteredList = new ArrayList<>();
        for (SanPham_Main item : list){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
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
        mAdapter = new Adapte_SanPham(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(    this));
        recyclerView.setAdapter(mAdapter);
    }
}
