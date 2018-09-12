package com.example.admin.imageloader.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.admin.imageloader.R;
import com.example.admin.imageloader.baseActivity.BaseActivity;

import javax.inject.Inject;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/8/21.
 */
public class FactoryActivity extends BaseActivity {

    @Inject
    Product mProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll);
    }

    @Override
    protected void bindData() {
        DaggerFactoryActivityComponent.create().inject(this);
        Toast.makeText(this,mProduct.hashCode()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {
    }

    @Override
    public void initParam() {

    }
}
