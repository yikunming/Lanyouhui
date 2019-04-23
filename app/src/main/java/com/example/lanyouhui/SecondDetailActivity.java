package com.example.lanyouhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

//import com.jcodecraeer.xrecyclerview.XRecyclerView;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.uitl.ApiUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Adapter.AllDetailAdapter;
import Adapter.FistDetailAdapter;
import EntityClass.Comment;
import EntityClass.IndexComment;
import EntityClass.News;
import EntityClass.Result;
import EntityClass.ResultDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondDetailActivity extends AppCompatActivity {
    private RecyclerView comment_list;
    private RecyclerView.LayoutManager layoutManager;
    private News news=new News();
    private List<Comment>comments=new ArrayList<>();

    //详情页的绑定
    private TextView title;
    private TextView source;
    private TextView time;
    private ImageView photo;
    private TextView leiroong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_detail);

        //绑定布局
        title=(TextView)findViewById(R.id.title);
        source=(TextView)findViewById(R.id.x_toot);
        time=(TextView)findViewById(R.id.x_time);
        photo=(ImageView)findViewById(R.id.x_photo);
        leiroong=(TextView) findViewById(R.id.x_word);

//        for (int i=1;i<10;i++){
//            IndexComment index=new IndexComment();
//            index.setId("一颗柠檬");
//            index.setTime("18小时前");
//            index.setCommentcontent("菠萝菠萝蜜");
//            indexComments.add(index);
//        }

          getnba();
        comment_list=findViewById(R.id.comment_list);



    }


    private void getcommnt() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//                .addConverterFactory(new Retrofit2ConverterFactory())
                .build();
        // 步骤5:创建 网络请求接口 的实例
        CommentApi request = retrofit.create(CommentApi.class);
        //对 发送请求 进行封装
        Call<Result<Comment>> call = request.getCommentList(27);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Result<Comment>>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Result<Comment>> call, Response<Result<Comment>> response) {


                if(response.isSuccessful())
                {
                    comments = response.body().getSuccess();

                    comment_list .setLayoutManager(new LinearLayoutManager(SecondDetailActivity.this,LinearLayoutManager.VERTICAL,false));
                    //comment_list.setLayoutManager(linearLayoutManager);

                    AllDetailAdapter adapter=new AllDetailAdapter(comments);
                    comment_list.setAdapter(adapter);


                    for (int i=0;i<comments.size();i++){
                        Log.e("test comments",comments.toString());
                    }
                }

                // 步骤7：处理返回的数据结果
                Log.e("test", "请求成功: " );

            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Result<Comment>> call, Throwable t) {

            }



        });

    }

    private void getnba() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//                .addConverterFactory(new Retrofit2ConverterFactory())
                .build();
        // 步骤5:创建 网络请求接口 的实例
        NewsApi request = retrofit.create(NewsApi.class);
        //对 发送请求 进行封装
        Call<ResultDetail<News>> call = request.getNewsDetail(getIntent().getExtras().getInt("id"));

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<ResultDetail<News>>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<ResultDetail<News>> call, Response<ResultDetail<News>> response) {
                news = response.body().getSuccess();
                title.setText(news.getTitle());
                source.setText(news.getSource());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                time.setText(sdf.format(news.getTime()));
                Glide.with(SecondDetailActivity.this).load(ApiUrl.IMAGEBATS + news.getImg()).into(photo);
                // 步骤7：处理返回的数据结果
                Log.e("test", "请求成功: " );

            }
            //请求失败时回调
            @Override
            public void onFailure(Call<ResultDetail<News>> call, Throwable t) {
                Log.e("test", "请求失败: " + t.toString() );
            }
        });
    }




}

