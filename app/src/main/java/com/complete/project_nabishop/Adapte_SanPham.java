package com.complete.project_nabishop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapte_SanPham extends BaseAdapter {

    private Context context;
    private int layout;
    private List<SanPham_lv> arrayList;

    public Adapte_SanPham(Context context, int layout, List<SanPham_lv> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    view = inflater.inflate(layout,null);
    SanPham_lv sp = arrayList.get(i);
    TextView tv1 = view.findViewById(R.id.name);
    TextView tv2 = view.findViewById(R.id.gia);
    ImageView img = view.findViewById(R.id.img_sp);

    tv1.setText(sp.getTen());
    tv2.setText(sp.getGia());
    img.setImageResource(sp.getHinh());
        return view;
    }
    public void filterList(ArrayList<SanPham_lv> filteredList){
        arrayList = filteredList;
        notifyDataSetChanged();
    }
}
