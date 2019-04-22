package com.example.lanyouhui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.FirstFragment_adapter;
import EntityClass.Nbamessage;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class FirstFragment extends Fragment {
    public ListView listView;
    public BaseAdapter adapter;
    private List<Nbamessage>nbamessages=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_item,null);

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

        return view;
    }
}

