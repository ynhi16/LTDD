package com.complete.project_nabishop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SPMain_Adapter  extends RecyclerView.Adapter<SPMain_Adapter.SPViewHoder>{
    private Context mContext;
    private List<SanPham_Main> mListSP;

    public SPMain_Adapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<SanPham_Main> list){
        this.mListSP = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SPViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_main,parent,false);

        return new SPViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SPViewHoder holder, int position) {
        SanPham_Main sp = mListSP.get(position);
        if(sp == null){
            return;
        }

        holder.imgsp.setImageResource(sp.getImg());
        holder.ten.setText(sp.getName());
        holder.gia.setText(sp.getGia());
        holder.giacu.setText(sp.getGiacu());
    }

    @Override
    public int getItemCount() {
        if(mListSP != null){
            return  mListSP.size();

        }
        return 0;
    }


    public class SPViewHoder extends RecyclerView.ViewHolder{
        private ImageView imgsp;
        private TextView ten, gia, giacu;

        public SPViewHoder(@NonNull View itemView) {
            super(itemView);

            imgsp = itemView.findViewById(R.id.img);
            ten = itemView.findViewById(R.id.tv_name);
            gia = itemView.findViewById(R.id.tv_gia);
            giacu = itemView.findViewById(R.id.tv_gia_cu);

        }
    }
}
