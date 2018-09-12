package com.example.admin.imageloader

import android.os.Bundle
import com.example.admin.imageloader.baseActivity.BaseActivity

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/8/16.
 */
 class Main2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll)
    }

    override fun bindData() {

    }

    override fun initView() {

    }

    override fun initParam() {

    }

    fun sum(a: Int, b: Int): String {
        return (a + b).toString()
    }

}