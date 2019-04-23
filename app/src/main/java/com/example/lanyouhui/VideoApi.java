package com.example.lanyouhui;

import EntityClass.News;
import EntityClass.Result;
import EntityClass.Video;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface VideoApi  {

    /****新闻推荐****/
    @Headers("Content-Type:application/json;charset=utf-8")
    @GET("mybasketball//video/listvideos")
    Call<Result<Video>> getCall(@Query("Id")Integer id);
}
