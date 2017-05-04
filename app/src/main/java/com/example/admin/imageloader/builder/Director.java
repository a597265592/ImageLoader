package com.example.admin.imageloader.builder;

/**
 * Created by admin on 2017/5/4.
 */

public class Director {
    Builder mBuilder = null;

    public Director(Builder builder){
        mBuilder = builder;
    }

    public void constract(String board,String os,String display){
        mBuilder.builderBoard(board);
        mBuilder.builderDisplay(display);
        mBuilder.builderOS(os);
    }
}
