package com.example.lanyouhui.api;

import EntityClass.News;
import EntityClass.PostResult;
import EntityClass.Result;
import EntityClass.ResultDetail;
import EntityClass.UserLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiUser {

    /****新闻推荐****/

    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("mybasketball//news/listnews")
    Call<Result<UserLogin>> getCall(@Query("newsType")Integer type);

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
}
