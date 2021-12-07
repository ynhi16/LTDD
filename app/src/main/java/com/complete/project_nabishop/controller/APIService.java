package com.complete.project_nabishop.controller;

import com.complete.project_nabishop.SanPham_Main;
import com.complete.project_nabishop.SanPham_lv;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("listar")
    Call<List<SanPham_Main>> getSanPham();
    @GET("listshirt")
    Call<List<SanPham_Main>> getShirt();
    @GET("listpants")
    Call<List<SanPham_Main>> getPants();
    @GET("listdress")
    Call<List<SanPham_Main>> getDress();
    @GET("listshoes")
    Call<List<SanPham_Main>> getShoes();

}
