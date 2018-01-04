package com.example.admin.imageloader;

import android.app.Application;

/**
 * Created by admin on 2017/5/5.
 */

public class  MyApplication extends Application {

    private static MyApplication mApplication ;

    private MyApplication(){

    }
    public static MyApplication getInstance(){
        if (mApplication ==null){
            mApplication = new MyApplication();
        }
        return mApplication;
    }

}
