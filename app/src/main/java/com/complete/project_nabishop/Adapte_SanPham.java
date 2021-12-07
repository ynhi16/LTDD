package com.complete.project_nabishop;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class Adapte_SanPham extends RecyclerView.Adapter<Adapte_SanPham.MyViewHolder> {

    private Context mContext;
    private List<SanPham_Main> mListSP;

    public Adapte_SanPham(Context mContext, List<SanPham_Main> mListSP) {
        this.mContext = mContext;
        this.mListSP = mListSP;
    }

    @NonNull
    @Override
    public Adapte_SanPham.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.sanpham_lv,parent,false);
        return new Adapte_SanPham.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapte_SanPham.MyViewHolder holder, int position) {
        holder.title.setText(mListSP.get(position).getName());
        holder.money.setText(String.valueOf(mListSP.get(position).getGia()));
        //add hinh anh
        Glide.with(mContext).load(mListSP.get(position).getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mListSP.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView money;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            money = itemView.findViewById(R.id.gia);
            img = itemView.findViewById(R.id.img_sp);
        }
    }
    public void filterList(ArrayList<SanPham_Main> filteredList){
        mListSP = filteredList;
        notifyDataSetChanged();
    }
}
