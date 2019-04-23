package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.FirstFragment;
import com.example.lanyouhui.R;
import com.example.lanyouhui.uitl.ApiUrl;

import java.util.ArrayList;
import java.util.List;

import EntityClass.Nbamessage;
import EntityClass.News;

/**
 * Created by 易锟铭 on 2019/2/27.
 *
 */

public class FirstFragment_adapter extends BaseAdapter{
    public FirstFragment firstFragment;
    private LayoutInflater layoutInflater;
    private Context context;
    private List<News>news=new ArrayList<>();
    public FirstFragment_adapter(Context context, List<News> news) {
        this.firstFragment=firstFragment;
        this.news=news;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView , ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.first_item_item, null);
        ImageView fimage=convertView.findViewById(R.id.fimage);
        TextView information=convertView.findViewById(R.id.information);
        TextView root=convertView.findViewById(R.id.root);
        ImageView comment_image=convertView.findViewById(R.id.shijian);
        TextView comment=convertView.findViewById(R.id.time);
//        ImageView collect_image=convertView.findViewById(R.id.collect);
//        TextView collect=convertView.findViewById(R.id.collect_number);
//        ImageView unlike=convertView.findViewById(R.id.unlike);

        information.setText(news.get(position).getTitle());
        root.setText(news.get(position).getSource());
        comment.setText(String.valueOf(news.get(position).getTime()));
        //fimage.setImageResource(Integer.valueOf(news.get(position).getImg()));
        Glide.with(context).load(ApiUrl.IMAGEBATS + news.get(position).getImg()).into(fimage);

        //collect.setText(String.valueOf(nbamessages.get(position).getCollectnumber()));
        return convertView;
    }
}
