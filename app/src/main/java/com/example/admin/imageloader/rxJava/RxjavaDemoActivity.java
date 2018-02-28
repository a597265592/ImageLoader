package com.example.admin.imageloader.rxJava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.admin.imageloader.R;
import com.example.admin.imageloader.baseActivity.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/26.
 */

public class RxjavaDemoActivity extends BaseActivity {
    private static final String TAG = RxjavaDemoActivity.class.getName();
    private ArrayList<Integer> mIntegers = new ArrayList<>();
    private ArrayList<String> mStrings = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);
    }

    @Override
    protected void bindData() {
        Observable.concat(getStringObser(), getIntObser()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("观察者在线程为------------",Thread.currentThread().getName());
                Log.e(TAG + "输出", s);
            }
        });
        Observable.concat(Observable.just("a", "b", "c"), Observable.just("1", "2", "3"))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String integer) throws Exception {
                        Log.e(TAG, "concat : " + integer);
                    }
                });
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
                int delayTime = (int) (1 + Math.random() * 10);
                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "flatMap : accept : " + s + "\n");
                    }
                });
        Observable.fromIterable(mIntegers).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                return Observable.fromArray("结果 ="+integer);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG,s);
            }
        });
        Observable.just(1, 2, 3, 4, 5)
                .buffer(3, 2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(@NonNull List<Integer> integers) throws Exception {
                        Log.e(TAG, "buffer size : " + integers.size() + "\n");
                        Log.e(TAG, "buffer value : " );
                        for (Integer i : integers) {
                            Log.e(TAG, i + "");
                        }
                        Log.e(TAG, "\n");
                    }
                });
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initParam() {
        for (int i = 0; i < 5; i++) {
            mIntegers.add(i);
        }
    }

    public Observable<String> getStringObser() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                Log.e("被观察者所在的线程------------",Thread.currentThread().getName());
                e.onNext("a");
                e.onNext("b");
                e.onNext("c");
                e.onNext("d");
                e.onNext("e");
                e.onNext("f");
                e.onNext("g");
            }
        });
    }

    public Observable<String> getIntObser() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 4; i++) {
                    e.onNext(i + "");
                }
            }
        });
    }
}
