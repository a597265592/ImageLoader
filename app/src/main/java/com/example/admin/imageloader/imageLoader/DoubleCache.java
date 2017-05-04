package com.example.admin.imageloader.imageLoader;

import android.graphics.Bitmap;

/**
 * Created by admin on 2017/5/4.
 */

public class DoubleCache implements ImageCache{
    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache =new DiskCache();

    public Bitmap get(String url){
        Bitmap bitmap =mMemoryCache.get(url);
        if (bitmap == null){
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }


    public void put(String url,Bitmap bitmap){
        mMemoryCache.put(url,bitmap);
        mDiskCache.put(url,bitmap);
    }
}
