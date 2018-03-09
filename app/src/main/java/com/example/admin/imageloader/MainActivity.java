package com.example.admin.imageloader;

import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.imageloader.baseActivity.BaseActivity;
import com.example.admin.imageloader.greenDao.UserDaoManger;
import com.example.admin.imageloader.greenDao.UserInfo;
import com.example.annotation.BindView;
import com.example.api.CJViewBinder;

import java.util.List;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_app_text_view)
    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CJViewBinder.bind(this);
    }

    @Override
    protected void bindData() {
        mTextView.setText("绑定成功");
        List<UserInfo> userInfos = UserDaoManger.getInstance(this).queryUserListByAge(200);
        for (UserInfo userInfo: userInfos) {
            System.out.println(userInfo);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CJViewBinder.unBind(this);
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv_app_text_view);
    }


    @Override
    public void initParam() {

    }

}
