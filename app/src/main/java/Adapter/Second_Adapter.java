package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanyouhui.R;
import com.example.lanyouhui.SecondDetailActivity;
import com.example.lanyouhui.SecondFragment;
import com.example.lanyouhui.ThirdFragment;
//import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import EntityClass.Nbamessage;
import EntityClass.Nbamessages;

public class Second_Adapter extends RecyclerView.Adapter<Second_Adapter.ViewHolder> {
   private List<Nbamessages>nbamessages=new ArrayList<>();
   Context context;


    public Second_Adapter(List<Nbamessages>nbamessages,Context context){
        this.nbamessages=nbamessages;
        this.context=context;


    }




    public class ViewHolder extends RecyclerView.ViewHolder {
     private TextView txtHeader;
     private ImageView show_1;
        private ImageView show_2;
        private ImageView show_3;
        private TextView root;
        private ImageView delete;



        public ViewHolder(View v) {
            super(v);
            txtHeader=(TextView)v.findViewById(R.id.title_nba);
            show_1=(ImageView)v.findViewById(R.id.show_1);
            show_2=(ImageView)v.findViewById(R.id.show_2);
            show_3=(ImageView)v.findViewById(R.id.show_3);
            root=(TextView)v.findViewById(R.id.NBA_root);
            delete=(ImageView)v.findViewById(R.id.NBA_delet);

        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.second_item_item,parent,false);
        ViewHolder vh=new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtHeader.setText(nbamessages.get(position).getMessage());
        //holder.show_1.setImageResource(nbamessages.get(position).getShow_1());
        holder.root.setText(nbamessages.get(position).getRoot());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SecondDetailActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nbamessages.size();
    }

}