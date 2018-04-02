package com.example.admin.imageloader.api;

import com.example.admin.imageloader.model.AiModel;
import com.example.admin.imageloader.model.ToeknModel;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/3/13.
 */

public interface Api {

//    Api ready = retrofit.create(Api.class);

    @POST("v1/lexer")
    Call<AiModel> GrammaticalAnalysis(@Path("text") String path);

    @POST("token")
    Call<ToeknModel> getToken(
            @Path("grant_type") String grant_type,
            @Path("client_id") String client_id,
            @Path("client_secret") String client_secret
    );


}
