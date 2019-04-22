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
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Adapter.FirstFragment_adapter;
import EntityClass.Nbamessage;
import EntityClass.News;
import EntityClass.RetrofitFactory;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class FirstFragment extends Fragment {
    public ListView listView;
    public BaseAdapter adapter;
    private String TAG;
    private List<Nbamessage>nbamessages=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_item,null);



        //get();
        listView =(ListView)view.findViewById(R.id.nba_listview);//获取list view控件
        for (int i=0;i<10;i++){
            Nbamessage nba=new Nbamessage();
            nba.setMessage("莱昂纳德21分 欧文仅7分 绿军早猛龙吊打惨遭三连败");
            nba.setRoot("OnFire");
            //nba.setCommentimage();
            nba.setCommentnumber(20);
            nba.setCollectnumber(30);
            nbamessages.add(nba);
            //adapter= new FirstFragment_adapter(FirstFragment.this,nbamessages);
            listView.setAdapter(new FirstFragment_adapter(getActivity(),nbamessages));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DetailActivity.class);
                startActivity(intent);
            }
        });
        jiexi();
        return view;
    }

    private void jiexi() {

        String url="http://172.17.191.121:8082/mybasketball//news/listnews?news";
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "大苏打撒旦撒旦 " + response.toString());

            }
        });



//    private void get(){
//        RetrofitFactory.getInstance().getT(0).enqueue(new Callback<List<News>>() {
//            @Override
//            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
//                Log.d("json 测试",response.body().get(0).getContent());
//            }
//
//            @Override
//            public void onFailure(Call<List<News>> call, Throwable t) {
//
//            }
//        });
//    }

}
}

