package com.example.admin.imageloader;

import android.app.Application;

import com.example.admin.imageloader.Config.ThirdConfigManager;
import com.example.admin.imageloader.share.UMengShareHelper;
import com.umeng.commonsdk.UMConfigure;

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

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, ThirdConfigManager.U_MEN_APP_KEY,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        UMengShareHelper.init(this);
    }
}
