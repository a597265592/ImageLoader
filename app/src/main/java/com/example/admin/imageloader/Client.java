package com.example.admin.imageloader;


import com.example.admin.imageloader.builder.Builder;
import com.example.admin.imageloader.builder.Director;
import com.example.admin.imageloader.builder.MacBuilder;

/**
 * Created by admin on 2017/4/25.
 */
public class Client {

    public static void main(String[] args) {

        Builder builder = new MacBuilder();
        Director director = new Director(builder);
        director.constract("inter主板","ios 10系统","aoc显示器");
//        System.out.println(builder.create().toString());
        System.out.println(new MacBuilder().builderOS("ios 10系统1").builderBoard("inter主板1").builderDisplay("aoc显示器1").create().toString());
    }
}