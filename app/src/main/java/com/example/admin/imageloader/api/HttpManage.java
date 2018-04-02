package com.example.admin.imageloader.api;

import com.example.admin.imageloader.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 35304 on 2018/3/16.
 */

public class HttpManage {
    /**
     * 定义基本地址
     */
    public static final String HOST = "http://192.168.0.109:8091/";
    /**
     * 设置连接超时的值
     */
    private static final int TIMEOUT = 10;
    /**
     * 声明HttpService对象
     */
    protected HttpService httpService;

    /**
     * 声明HttpManager对象
     */
    private Retrofit retrofit;

    private static HttpManage httpManager;
    private final Map<Class, Object> apiClassCache = new ConcurrentHashMap<>();

    private HttpManage() {
        //新建一个文件用来缓存网络请求
        File cacheDirectory = new File(MyApplication.getInstance().getApplicationContext()
                .getCacheDir().getAbsolutePath(), "HttpCache");
        //实例化一个OkHttpClient.Builder
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置连接超时
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        //设置从主机读信息超时
        builder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        //设置写信息超时
        builder.writeTimeout(TIMEOUT, TimeUnit.SECONDS);
        //设置缓存文件
        builder.cache(new Cache(cacheDirectory, 10 * 1024 * 1024));
        //设置okhttp拦截器，这样做的好处是可以为你的每一个
        //retrofit2的网络请求都增加相同的head头信息，而不用每一个请求都写头信息
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json; charset=UTF-8")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Accept", "*/*")
                        .header("Cache-Control", String.format("public, max-age=%d", 60))
                        .removeHeader("Pragma")
                        .build();
                return chain.proceed(request);
            }
        });
        retrofit = new Retrofit.Builder()
                .client(builder.build())
//如果网络访问返回的字符串，而不是json数据格式，要使用下面的转换器
//                .addConverterFactory(ScalarsConverterFactory.create())
                //如果网络访问返回的是json字符串，使用gson转换器
                .addConverterFactory(GsonConverterFactory.create())
//此处顺序不能和上面对调，否则不能同时兼容普通字符串和Json格式字符串
//为了支持rxjava,需要添加下面这个把 Retrofit 转成RxJava可用的适配类
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//基本网络地址
                .baseUrl(getHost()).build();
    }

    /**
     * 如果有不同的请求HOST可继承此类并Override
     *
     * @return
     */
    protected String getHost() {
        return HOST;
    }

    /**
     * 使用单例模式
     */
    public static HttpManage getInstance() {
        if (httpManager == null) {
            synchronized (HttpManage.class) {
                if (httpManager == null) {
                    httpManager = new HttpManage();
                }
            }
        }
        return httpManager;
    }

    public <T> T getApi(Class<T> clazz) {
        T result = (T) apiClassCache.get(clazz);
        if (result != null) {
            return result;
        }
        result = (T) apiClassCache.get(clazz);
        synchronized (apiClassCache) {
            if (result == null) {
                result = retrofit.create(clazz);
                apiClassCache.put(clazz, result);
            }
        }
        return result;
    }

}
