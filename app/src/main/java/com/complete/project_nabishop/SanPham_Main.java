package com.complete.project_nabishop;

public class SanPham_Main {
    private int img;
    private String name, gia,giacu ;

    public SanPham_Main(int img,String name,String gia, String giacu ) {
        this.img = img;
        this.name = name;
        this.gia = gia;
        this.giacu = giacu;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGiacu() {
        return giacu;
    }

    public void setGiacu(String giacu) {
        this.giacu = giacu;
    }

}
