package com.example.admin.imageloader.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 陈杰 on 2018/2/14.
 */

public class ServiceDemo {
    public static void main(String[] args){
        Retrofit retrofit  = new Retrofit.Builder().baseUrl("www.baidu.com").addConverterFactory(GsonConverterFactory.create()).build();
    }
}
