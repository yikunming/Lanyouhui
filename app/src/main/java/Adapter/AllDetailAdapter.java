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

import com.example.lanyouhui.R;
//import com.jcodecraeer.xrecyclerview.XRecyclerView;


import java.util.ArrayList;
import java.util.List;

import EntityClass.IndexComment;

public class AllDetailAdapter extends RecyclerView.Adapter<AllDetailAdapter.ViewHolder> {
    private List<IndexComment>indexComments=new ArrayList<>();


    public  AllDetailAdapter(List<IndexComment>indexComments){
        this.indexComments=indexComments;

    }

public class ViewHolder extends RecyclerView.ViewHolder{



        private TextView header ;
        private TextView time;
        private TextView comment;
        private TextView id;

        public ViewHolder(View v){
            super(v);
           // header=v.findViewById(R.id.tv_user_nickname);
            time=v.findViewById(R.id.tv_comment_pubdate);
            comment=v.findViewById(R.id.tv_comment_content);
            id=v.findViewById(R.id.tv_user_nickname);
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

        holder.id.setText(indexComments.get(position).getHeader());
        holder.time.setText(indexComments.get(position).getTime());
        holder.comment.setText(indexComments.get(position).getCommentcontent());


    }

    @Override
    public int getItemCount() {
        return indexComments.size();
    }
}
