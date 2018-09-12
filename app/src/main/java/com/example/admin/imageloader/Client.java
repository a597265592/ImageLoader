package com.example.admin.imageloader;


/**
 * Created by admin on 2017/4/25.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println(factorial(5)+"");
    }

    public static int factorial (int n) {  // 1.
        if (n == 0)  // 2.
            return 1; // 3.
        else // 4.
            return n* factorial(n-1); // 5.
    }
}