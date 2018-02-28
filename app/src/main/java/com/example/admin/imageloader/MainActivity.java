package com.example.admin.imageloader;

import android.os.Bundle;

import com.example.admin.imageloader.baseActivity.BaseActivity;
import com.example.admin.imageloader.greenDao.UserDaoManger;
import com.example.admin.imageloader.greenDao.UserInfo;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void bindData() {
        List<UserInfo> userInfos = UserDaoManger.getInstance(this).queryUserList(2);
        for (UserInfo userInfo: userInfos) {
            System.out.println(userInfo);
        }
    }

    @Override
    protected void initView() {
    }


    @Override
    public void initParam() {

    }

}
