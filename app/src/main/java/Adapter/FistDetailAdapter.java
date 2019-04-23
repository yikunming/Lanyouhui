package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.R;
import com.example.lanyouhui.uitl.ApiUrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import EntityClass.Comment;

/**
 * Created by 易锟铭 on 2019/3/5.
 */

public class FistDetailAdapter extends BaseAdapter {


    private Context context;
    private List<Comment>comments;
    private LayoutInflater layoutInflater;

   public FistDetailAdapter(Context context, List<Comment>comments){
        this.context=context;
        this.comments=comments;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view= layoutInflater.inflate(R.layout.frist_detail_item,null);

        TextView header=(TextView)view.findViewById(R.id.tv_user_nickname);
        TextView time=(TextView)view.findViewById(R.id.tv_comment_pubdate);
        TextView comment=(TextView)view.findViewById(R.id.tv_comment_content);
        ImageView iv_user_headimg=(ImageView)view.findViewById(R.id.iv_user_headimg);


         Glide.with(context).load(ApiUrl.HEADBATS + comments.get(position).getImg()).into(iv_user_headimg);
         header.setText(comments.get(position).getName());


         SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
         time.setText(sdf.format(comments.get(position).getCreateDate()));
         comment.setText(comments.get(position).getReplyMsg());

        return view;
    }
}
