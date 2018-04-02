package com.example.admin.imageloader.api;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by 35304 on 2018/3/15.
 */

public interface HttpService {

      HttpService ready = HttpManage.getInstance().getApi(HttpService.class);

      @POST("SignUp.php")
      Call<String> getSignUpResult(@Query("email") String email, @Query("password") String password);

      @POST("SignIn.php")
      Call<String> getSignInResult(@Query("account") String email, @Query("password") String password);

      @Multipart
      @POST("upload")
     Call<ResponseBody> upload(@Part("description") RequestBody description);



}
