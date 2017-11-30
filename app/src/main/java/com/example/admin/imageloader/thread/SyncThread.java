package com.example.admin.imageloader.thread;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static android.content.ContentValues.TAG;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2017/11/30.
 */

public class SyncThread {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
    }

}
