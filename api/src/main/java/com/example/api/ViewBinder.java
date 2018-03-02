package com.example.api;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/3/2.
 */

public interface  ViewBinder<T> {
    void bindView(T host, Object object, ViewFinder finder);

    void unBindView(T host);
}
