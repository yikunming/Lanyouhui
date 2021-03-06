package com.example.lanyouhui;

import EntityClass.News;
import EntityClass.Result;
import EntityClass.ResultDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsApi {

    /****新闻推荐****/
    @Headers("Content-Type:application/json;charset=utf-8")
    @GET("mybasketball//news/listnews")
    Call<Result<News>> getCall(@Query("newsType")Integer type);
    // 注解里传入 网络请求 的部分URL地址
    // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
    // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
    // getCall()是接受网络请求数据的方法

    /****新闻推荐****/
    @Headers("Content-Type:application/json;charset=utf-8")
    @GET("mybasketball//news/getnewsbyid")
    Call<ResultDetail<News>> getNewsDetail(@Query("newsId")Integer id);
}
