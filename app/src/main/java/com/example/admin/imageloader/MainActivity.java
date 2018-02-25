package com.example.admin.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv_text);
        mTextView.setBackgroundDrawable(new XLRoundDrawable.Builder().setAllRoundDp(75).setCenterColor(getResources().getColor(R.color.colorAccent)).setStrokeWidthDp(2).builder());

    }
}
