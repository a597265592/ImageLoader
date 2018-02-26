package com.example.admin.imageloader.thread;

import android.util.Log;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/26.
 */

public class ReportTask {
    public void report1(){
        Log.e("R公司","1号业务员" + "进办公室");
        try{
            Log.e("R公司","1号业务员" + "开始汇报");
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.e("R公司","1号业务员" + "汇报完毕");
        Log.e("R公司","1号业务员" + "出办公室");
    }

    public void report2(){
        Log.e("R公司","2号业务员" + "进办公室");
        try{
            Log.e("R公司","2号业务员" + "开始汇报");
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }
        Log.e("R公司","2号业务员" + "汇报完毕");
        Log.e("R公司","2号业务员" + "出办公室");
    }
}


