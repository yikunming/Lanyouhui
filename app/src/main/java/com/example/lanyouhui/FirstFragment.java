package com.example.lanyouhui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lanyouhui.uitl.ApiUrl;

import java.util.ArrayList;
import java.util.List;

import Adapter.FirstFragment_adapter;
import EntityClass.Nbamessage;
import EntityClass.News;
import EntityClass.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class FirstFragment extends Fragment {
    private static String TAG = "test";
    public ListView listView;
    public BaseAdapter adapter;
    private String res;
    private String content;

    private List<News> news = new ArrayList<>();
    private EditText editText;//评论编辑框
    private ImageView imageView;//发送评论图标
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_item,null);

        editText = (EditText) view.findViewById(R.id.edittext);
        imageView=(ImageView) view.findViewById(R.id.send);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String finalContent = content;
//                content = editText.getText().toString();
//
//
//            }
//        });

        request();
        listView =(ListView)view.findViewById(R.id.nba_listview);//获取list view控件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("id",news.get(position).getId());
                startActivity(intent);
            }
        });
        return view;
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//                .addConverterFactory(new Retrofit2ConverterFactory())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        NewsApi request = retrofit.create(NewsApi.class);
        //对 发送请求 进行封装
        Call<Result<News>> call = request.getCall(0);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Result<News>>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Result<News>> call, Response<Result<News>> response) {
                // 步骤7：处理返回的数据结果
                news = response.body().getSuccess();
                listView.setAdapter(new FirstFragment_adapter(getActivity(),news));
                //listView.setAdapter(new FirstFragment_adapter(getActivity(),news));
                Log.e(TAG, "请求成功: " + news.get(0).getImg());


            }
            //请求失败时回调
            @Override
            public void onFailure(Call<Result<News>> call, Throwable t) {
                Log.e(TAG, "请求失败: " + t.toString() );
            }
        });
    }
}

