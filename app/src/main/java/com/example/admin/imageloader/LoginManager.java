package com.example.admin.imageloader;

import com.example.admin.imageloader.api.Api;
import com.example.admin.imageloader.api.HttpService;
import com.example.admin.imageloader.model.AiModel;
import com.example.admin.imageloader.model.ToeknModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/3/13.
 */

public class LoginManager {
    private static LoginManager mLoginManager;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (mLoginManager == null){
            synchronized (LoginManager.class){
                if(mLoginManager == null){
                    mLoginManager = new LoginManager();
                    HttpService.ready.getSignInResult("","").enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                }
            }
        }
        return mLoginManager;
    }


}
