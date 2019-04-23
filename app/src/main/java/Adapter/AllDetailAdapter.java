package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.R;
import com.example.lanyouhui.uitl.ApiUrl;
//import com.jcodecraeer.xrecyclerview.XRecyclerView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import EntityClass.Comment;
import EntityClass.IndexComment;

public class AllDetailAdapter extends RecyclerView.Adapter<AllDetailAdapter.ViewHolder> {
    private List<Comment>comments=new ArrayList<>();
    Context context;

    public  AllDetailAdapter( Context context) {
        this.context=context;
    }

    public  AllDetailAdapter(List<Comment>comments ){
        this.comments=comments;



    }

public class ViewHolder extends RecyclerView.ViewHolder{



        private TextView header ;
        private TextView time;
        private TextView comment;
        private ImageView id;

        public ViewHolder(View v){
            super(v);

            header=v.findViewById(R.id.tv_user_nickname);
            time=v.findViewById(R.id.tv_comment_pubdate);
            comment=v.findViewById(R.id.tv_comment_content);
            id=v.findViewById(R.id.iv_user_headimg);
        }
}

    @NonNull
    @Override
    public AllDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_detail_item,parent,false);

        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllDetailAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(ApiUrl.HEADBATS + comments.get(position).getImg()).into(holder.id);
        holder.header.setText(comments.get(position).getName());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        holder.time.setText(sdf.format(comments.get(position).getCreateDate()));
        holder.comment.setText(comments.get(position).getReplyMsg());


    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
