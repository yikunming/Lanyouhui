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

import java.util.ArrayList;
import java.util.List;

import Adapter.Second_Adapter;
import EntityClass.Nbamessages;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class ThirdFragment extends Fragment {
    private RecyclerView NBA_recycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter second_Adapter;
    private List<Nbamessages> nbamessages=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_item,null);

        for (int i = 0; i < 10; i++) {
            Nbamessages messages = new Nbamessages();
            messages.setMessage("NBA季后赛巡礼（2）：勇士队史上最幸福的一届球迷" + i);
            messages.setRoot("老虎体育");
            nbamessages.add(messages);
        }

        NBA_recycler = (RecyclerView) view.findViewById(R.id.CBA_recycler);


        NBA_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        second_Adapter = new Second_Adapter(nbamessages,getContext());
        NBA_recycler.setAdapter(second_Adapter);
        return view;
    }

}
