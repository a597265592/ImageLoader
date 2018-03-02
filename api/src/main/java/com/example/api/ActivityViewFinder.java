package com.example.api;

import android.app.Activity;
import android.view.View;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/3/2.
 */

public class ActivityViewFinder implements ViewFinder {
    @Override
    public View findView(Object object, int id) {
        return ((Activity) object).findViewById(id);
    }
}
