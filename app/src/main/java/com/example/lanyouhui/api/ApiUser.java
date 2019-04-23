package com.example.lanyouhui.api;

import EntityClass.News;
import EntityClass.PostResult;
import EntityClass.Result;
import EntityClass.ResultDetail;
import EntityClass.UserInfo;
import EntityClass.UserLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiUser {

    /**
     * 登录
     */
    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("mybasketball//user/login")
    Call<PostResult> loginUserInfo(@Body UserLogin userLogin);

    /**
     * 注册
     */
    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("mybasketball//user/register")
    Call<PostResult> registerUserInfo(@Body UserLogin userLogin);

    /**
     * 查看用户信息
     * @param userPhone
     * @return
     */
    @Headers("Content-Type:application/json;charset=utf-8")
    @GET("mybasketball//user/getuserbyphone")
    Call<ResultDetail<UserInfo>> getUserInfo(@Query("userPhone")String userPhone);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("mybasketball//user/modifyuserinfo")
    Call<PostResult> modifyUserInfo(@Body UserInfo userInfo);

}
