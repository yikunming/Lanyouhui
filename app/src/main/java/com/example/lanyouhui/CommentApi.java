package com.example.lanyouhui;

import EntityClass.Comment;
import EntityClass.PostResult;
import EntityClass.Result;
import EntityClass.UserLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CommentApi {
    /****获取全部评论****/

    @Headers("Content-Type:application/json;charset=utf-8")
    @GET("mybasketball//comment/getcommentlist")
    Call<Result<Comment>> getCommentList(@Query("newsId")Integer id);

    /******评论******/

    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("mybasketball//comment/insertcommentlist")
    Call<PostResult> commentlist(@Body Comment comment);





}
