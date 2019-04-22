package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanyouhui.FirstFragment;
import com.example.lanyouhui.R;

import java.util.ArrayList;
import java.util.List;

import EntityClass.Nbamessage;

/**
 * Created by 易锟铭 on 2019/2/27.
 */

public class FirstFragment_adapter extends BaseAdapter{
    public FirstFragment firstFragment;
    private LayoutInflater layoutInflater;
    private Context context;
    private List<Nbamessage>nbamessages=new ArrayList<>();
    public FirstFragment_adapter(Context context, List<Nbamessage> nbamessages) {
        this.firstFragment=firstFragment;
        this.nbamessages=nbamessages;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return nbamessages.size();
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
        ImageView comment_image=convertView.findViewById(R.id.comment);
        TextView comment=convertView.findViewById(R.id.comment_number);
//        ImageView collect_image=convertView.findViewById(R.id.collect);
//        TextView collect=convertView.findViewById(R.id.collect_number);
//        ImageView unlike=convertView.findViewById(R.id.unlike);

        information.setText(nbamessages.get(position).getMessage());
        root.setText(nbamessages.get(position).getRoot());
        comment.setText(String.valueOf(nbamessages.get(position).getCommentnumber()));
        //collect.setText(String.valueOf(nbamessages.get(position).getCollectnumber()));
        return convertView;
    }
}
