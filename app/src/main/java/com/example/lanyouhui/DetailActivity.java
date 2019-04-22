package com.example.lanyouhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.FistDetailAdapter;
import EntityClass.IndexComment;


/**
 * Created by 易锟铭 on 2019/3/1.
 */

public class DetailActivity extends AppCompatActivity {
    private ListViewForScrollView listViewForScrollView;
    private List<IndexComment>indexCommentList=new ArrayList<>();
    private FistDetailAdapter fistDetailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fist_detail);

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
}