package com.example.admin.imageloader.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2017/10/16.
 */

public class FragmentActivity1 extends FragmentActivity {

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        return super.onCreateView(name, context, attrs);
    }
}
