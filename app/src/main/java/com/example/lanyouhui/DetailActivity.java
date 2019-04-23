package com.example.lanyouhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lanyouhui.uitl.ApiUrl;

import java.util.ArrayList;
import java.util.List;

import Adapter.FistDetailAdapter;
import EntityClass.IndexComment;
import EntityClass.News;
import EntityClass.Result;
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
    private List<IndexComment>indexCommentList=new ArrayList<>();
    private List<News>news=new ArrayList<>();
    private FistDetailAdapter fistDetailAdapter;

    //详情页的绑定
    private TextView title;
    private TextView source;
    private TextView time;
    private ImageView photo;
    private TextView leiroong;


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

        //邦定数据



        //获取详情页信息；
         getdetail();



       listViewForScrollView=(ListViewForScrollView)findViewById(R.id.comment_list);

       for (int i=0;i<=5;i++){
           IndexComment indexComment=new IndexComment();
           indexComment.setId("阿迪达斯");
           indexComment.setTime("1小时前");
           indexComment.setCommentcontent("詹姆斯我爱你");

           indexCommentList.add(indexComment);

       }

        fistDetailAdapter=new FistDetailAdapter(DetailActivity.this,indexCommentList);
        listViewForScrollView.setAdapter(fistDetailAdapter);

    }

    private void getdetail() {

//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(ApiUrl.APIBAST)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        NewsApi request=retrofit.create(NewsApi.class);
//
//
//
//
//        Call<Result<News>> call = null;
//          if (call==request.getCall(0)){
//              call.enqueue(new Callback<Result<News>>() {
//                  @Override
//                  public void onResponse(Call<Result<News>> call, Response<Result<News>> response) {
//
//
//
//                      news = response.body().getSuccess();
//
//                  }
//
//                  @Override
//                  public void onFailure(Call<Result<News>> call, Throwable t) {
//
//                  }
//              });
//          }




    }
}