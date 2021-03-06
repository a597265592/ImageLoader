package com.example.admin.imageloader.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 2017/5/4.
 */

public class DiskCache implements ImageCache{
    private static String cacheDir = "sdcard/cache";

    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir+url);
    }

    public void put(String url, Bitmap bitmap){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(cacheDir+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null){
                try{
                   fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
