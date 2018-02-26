package com.example.admin.imageloader.baseActivity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/2/26.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        init();
    }

    private void init(){
        initParam();
        initView();
        bindData();
    }


    protected abstract void bindData();

    protected abstract void initView();

    public abstract void initParam() ;


}