package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lanyouhui.R;

import java.util.ArrayList;
import java.util.List;

import EntityClass.IndexComment;

/**
 * Created by 易锟铭 on 2019/3/5.
 */

public class FistDetailAdapter extends BaseAdapter {


    private Context context;
    private List<IndexComment>indexCommentList=new ArrayList<>();
    private LayoutInflater layoutInflater;

   public FistDetailAdapter(Context context, List<IndexComment> indexCommentList){
        this.context=context;
        this.indexCommentList=indexCommentList;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return indexCommentList.size();
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

        header.setText(indexCommentList.get(position).getHeader());
        time.setText(indexCommentList.get(position).getTime());
        comment.setText(indexCommentList.get(position).getCommentcontent());


        return view;
    }
}
