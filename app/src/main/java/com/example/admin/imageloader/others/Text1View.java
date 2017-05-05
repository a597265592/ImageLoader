package com.example.admin.imageloader.others;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.imageloader.builder.Computer;

/**
 * Created by admin on 2017/5/5.
 */

public class Text1View extends View implements TextInterface{


    public Text1View(Context context) {
        super(context);
    }

    public Text1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Text1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void bindData(Computer computer) {

    }
}
