package com.example.lanyouhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.AllDetailAdapter;
import EntityClass.IndexComment;

public class SecondDetailActivity extends AppCompatActivity {
    private RecyclerView comment_list;
    private RecyclerView.LayoutManager layoutManager;
    private List<IndexComment>indexComments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_detail);

        for (int i=1;i<10;i++){
            IndexComment index=new IndexComment();
            index.setId("一颗柠檬");
            index.setTime("18小时前");
            index.setCommentcontent("菠萝菠萝蜜");
            indexComments.add(index);
        }


        comment_list=findViewById(R.id.comment_list);

        comment_list .setLayoutManager(new LinearLayoutManager(SecondDetailActivity.this,LinearLayoutManager.VERTICAL,false));
        //comment_list.setLayoutManager(linearLayoutManager);

        AllDetailAdapter adapter=new AllDetailAdapter(indexComments);
        comment_list.setAdapter(adapter);


    }
}
