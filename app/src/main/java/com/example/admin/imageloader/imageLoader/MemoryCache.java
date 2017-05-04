package com.example.admin.imageloader.imageLoader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by admin on 2017/5/4.
 */

public class MemoryCache implements ImageCache{
    LruCache<String,Bitmap> mMemoryCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        //计算可使用的最大内存
        final  int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = maxMemory/4;
        mMemoryCache = new LruCache<String ,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return mMemoryCache.get(url);
    }
}
