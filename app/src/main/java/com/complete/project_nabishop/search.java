package com.complete.project_nabishop;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;

public class search extends AppCompatActivity {
    private ListView lv;
    private ArrayList<SanPham_lv> arrayList;
    private Adapte_SanPham adapter;
    private EditText edt;
    private FrameLayout fr_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);
        lv = (ListView) findViewById(R.id.lv_sp);
        edt = (EditText) findViewById(R.id.edt_search);
        fr_back =(FrameLayout) findViewById(R.id.btn_back_search);
        arrayList = new ArrayList<>();
        arrayList.add(new SanPham_lv("Girl trendy sweater", "310.000 đ",R.drawable.a0));
        arrayList.add(new SanPham_lv("Dr Martens Holly Ribbon Flatform Shoes", "250.000 đ",R.drawable.a1));
        arrayList.add(new SanPham_lv("Flower feet", "250.000đ",R.drawable.a3));
        arrayList.add(new SanPham_lv("Balbina Blouse & Dress", "350.000 đ",R.drawable.a4));
        arrayList.add(new SanPham_lv("Dr. Martens Jadon boots - White", "400.000 đ",R.drawable.a5));
        arrayList.add(new SanPham_lv("Air Jordan 1 Pink", "780.000 ss",R.drawable.a9));
        arrayList.add(new SanPham_lv("Collared Long-Sleeve Midi A-Line Dress", "320.000 đ",R.drawable.a7));
        arrayList.add(new SanPham_lv("Nike Air Force 1", "600.000 đ",R.drawable.a10));

        adapter = new Adapte_SanPham(search.this, R.layout.sanpham_lv,arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(search.this, product_detail.class);
                    startActivity(intent);
                }
            }
        });
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
        ArrayList<SanPham_lv> filteredList = new ArrayList<>();
        for (SanPham_lv item : arrayList){
            if(item.getTen().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}
