package com.complete.project_nabishop;

import com.google.gson.annotations.SerializedName;

public class SanPham_Main {
    @SerializedName("tenSP")
    private String name;
    @SerializedName("donGia")
    private int gia;
    @SerializedName("tenHA")
    private String img;

    public SanPham_Main(String name, int gia, String img) {
        this.name = name;
        this.gia = gia;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
