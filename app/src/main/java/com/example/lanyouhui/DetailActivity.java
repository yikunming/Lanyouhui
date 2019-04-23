package com.example.lanyouhui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.api.ApiUser;
import com.example.lanyouhui.uitl.ApiUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Adapter.FistDetailAdapter;
import EntityClass.Comment;
import EntityClass.News;
import EntityClass.PostResult;
import EntityClass.Result;
import EntityClass.ResultDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 *
 * Created by 易锟铭 on 2019/3/1.
 */

public class DetailActivity extends AppCompatActivity {
    private ListViewForScrollView listViewForScrollView;
    private List<Comment>comments=new ArrayList<>();

    private News news=new News();
    private FistDetailAdapter fistDetailAdapter;

    //详情页的绑定
    private TextView title;
    private TextView source;
    private TextView time;
    private ImageView photo;
    private TextView leiroong;

    private EditText editText;
    private ImageView imageView;
    private String content;
    private int newsId;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fist_detail);

        //绑定布局
        title=(TextView)findViewById(R.id.title);
        source=(TextView)findViewById(R.id.x_toot);
        time=(TextView)findViewById(R.id.x_time);
        photo=(ImageView)findViewById(R.id.x_photo);
        leiroong=(TextView) findViewById(R.id.x_word);

        back=(ImageView)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent ( DetailActivity.this,FirstFragment.class) ;
                startActivity(intent);

            }
        });

         editText=(EditText)findViewById(R.id.edittext);
         imageView=(ImageView)findViewById(R.id.send);





         newsId = getIntent().getExtras().getInt("id");

         imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                     final String finalContent = content;
                     //content = editText.getText().toString();

                     Comment comment = new Comment();

                     comment.setReplyMsg(editText.getText().toString());//获取编辑框的数据
                     comment.setUserId(6);
                     comment.setCreateDate(new Date());
                     comment.setNewsId(newsId);
                     comment.setLikes(0);

                     comments.add(comment);


                 //步骤4:创建Retrofit对象
                 Retrofit retrofit = new Retrofit.Builder()
                         .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                         .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析
                         .build();

                     CommentApi request = retrofit.create(CommentApi.class);

                     Call<PostResult> call = request.commentlist(comment);


                     call.enqueue(new Callback<PostResult>() {
                         @Override
                         public void onResponse(Call<PostResult> call, Response<PostResult> response) {


                             if (response.isSuccessful()) {
                                 if (response.body().isSuccess())
                                 {
                                     Toast.makeText(DetailActivity.this, "评论成功!", Toast.LENGTH_SHORT).show();
                                     Log.e("test", "onResponse: "+ comment);

                                     fistDetailAdapter.notifyDataSetChanged();
                                 }
                             }

                         }

                         @Override
                         public void onFailure(Call<PostResult> call, Throwable t) {

                         }

                     });
             }
         });






                 listViewForScrollView = (ListViewForScrollView) findViewById(R.id.comment_list);
                 //邦定数据

                 //获取详情页信息；
                 getdetail();

                 //获取评论信息
                 getcommnt();

//
//       for (int i=0;i<=5;i++){
//           IndexComment indexComment=new IndexComment();
//           indexComment.setId("阿迪达斯");
//           indexComment.setTime("1小时前");
//           indexComment.setCommentcontent("詹姆斯我爱你");
//
//           indexCommentList.add(indexComment);
//
//       }

//        fistDetailAdapter=new FistDetailAdapter(DetailActivity.this,comments);
                 //listViewForScrollView.setAdapter(fistDetailAdapter);

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
                 Call<Result<Comment>> call = request.getCommentList(getIntent().getExtras().getInt("id"));

                 //步骤6:发送网络请求(异步)
                 call.enqueue(new Callback<Result<Comment>>() {

                     //请求成功时回调
                     @Override
                     public void onResponse(Call<Result<Comment>> call, Response<Result<Comment>> response) {


                         if (response.isSuccessful()) {
                             comments = response.body().getSuccess();
                             fistDetailAdapter = new FistDetailAdapter(DetailActivity.this, comments);
                             listViewForScrollView.setAdapter(fistDetailAdapter);

                             for (int i = 0; i < comments.size(); i++) {
                                 Log.e("test comments", comments.toString());
                             }
                         }

                         // 步骤7：处理返回的数据结果
                         Log.e("test", "请求成功: ");

                     }

                     //请求失败时回调
                     @Override
                     public void onFailure(Call<Result<Comment>> call, Throwable t) {

                     }


                 });

             }

             private void getdetail() {

//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(ApiUrl.APIBAST)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        NewsApi request=retrofit.create(NewsApi.class);
//
//        Call<ResultDetail<News>> call =  request.getNewsDetail(getIntent().getExtras().getInt("id"));
//        Log.e("test", "getdetail: "+getIntent().getExtras().getInt("id") );
//
//              call.enqueue(new Callback<ResultDetail<News>>() {
//                  @Override
//                  public void onResponse(Call<ResultDetail<News>> call, Response<ResultDetail<News>> response) {
//
//                      title.setText(news.getTitle());
//                      source.setText(news.getSource());
//                      time.setText((CharSequence) news.getTime());
//                      Glide.with(DetailActivity.this).load(ApiUrl.IMAGEBATS + news.getImg()).into(photo);
//
//                  }
//
//                  @Override
//                  public void onFailure(Call<ResultDetail<News>> call, Throwable t) {
//                      Log.e("test", "onFailure: "+ "请求失败" );
//                  }
//              });
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
                         leiroong.setText(news.getContent());
                         Glide.with(DetailActivity.this).load(ApiUrl.IMAGEBATS + news.getImg()).into(photo);
                         // 步骤7：处理返回的数据结果
                         Log.e("test", "请求成功: ");

                     }

                     //请求失败时回调
                     @Override
                     public void onFailure(Call<ResultDetail<News>> call, Throwable t) {
                         Log.e("test", "请求失败: " + t.toString());
                     }
                 });
             }




    }