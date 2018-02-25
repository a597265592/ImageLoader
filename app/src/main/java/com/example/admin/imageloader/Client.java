package com.example.admin.imageloader;


import com.example.admin.imageloader.others.ClassA;

/**
 * Created by admin on 2017/4/25.
 */
public class Client {

    public static void main(String[] args) {
        ClassA classA = new ClassA(){

            @Override
            public void a() {
                System.out.println("打印A成功");
            }
        };
        classA.a();
    }


}