package com.complete.project_nabishop.controller;

public class Client {
    public static final String URL_001="http://192.168.1.8:8080/sanpham/";
    public static APIService getAPIService(){
        return GetClient.GetClient(URL_001).create(APIService.class);
    }
}
