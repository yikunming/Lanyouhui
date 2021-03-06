package com.example.lanyouhui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lanyouhui.uitl.ApiUrl;

import java.util.ArrayList;
import java.util.List;

import Adapter.Second_Adapter;
import EntityClass.Nbamessages;
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

public class ThirdFragment extends Fragment {
    private RecyclerView NBA_recycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter second_Adapter;
    private List<News> news=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_item,null);

//        for (int i = 0; i < 10; i++) {
//            Nbamessages messages = new Nbamessages();
//            messages.setMessage("NBA季后赛巡礼（2）：勇士队史上最幸福的一届球迷" + i);
//            messages.setRoot("老虎体育");
//            nbamessages.add(messages);
//        }
              getcba();
        NBA_recycler = (RecyclerView) view.findViewById(R.id.CBA_recycler);




        second_Adapter = new Second_Adapter(news,getContext());
        NBA_recycler.setAdapter(second_Adapter);
        return view;
    }

    private void getcba() {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiUrl.APIBAST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        NewsApi request = retrofit.create(NewsApi.class);

        //对 发送请求 进行封装
        Call<Result<News>>call=request.getCall(2);

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Result<News>>() {
            @Override
            public void onResponse(Call<Result<News>> call, Response<Result<News>> response) {

                news=response.body().success;
                NBA_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

            }

            @Override
            public void onFailure(Call<Result<News>> call, Throwable t) {

            }
        });
    }

}
