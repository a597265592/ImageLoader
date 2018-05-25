package com.example.admin.imageloader;

import android.app.Application;

import com.example.admin.imageloader.Config.ThirdConfigManager;
import com.example.admin.imageloader.share.UMengShareHelper;
import com.umeng.commonsdk.UMConfigure;



import cn.jpush.android.api.JPushInterface;


/**
 * Created by admin on 2017/5/5.
 */

public class  MyApplication extends Application {

    private static MyApplication mApplication ;

    public static MyApplication getInstance(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        UMConfigure.init(this, ThirdConfigManager.U_MEN_APP_KEY,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        UMengShareHelper.init(this);
        JPushInterface.init(this);
        JPushInterface.setAlias(this, 1111,"test1");
    }
}
