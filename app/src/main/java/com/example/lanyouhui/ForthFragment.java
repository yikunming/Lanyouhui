package com.example.lanyouhui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

//import com.jcodecraeer.xrecyclerview.XRecyclerView;

import com.bumptech.glide.Glide;
import com.example.lanyouhui.uitl.ApiUrl;

import java.util.ArrayList;
import java.util.List;

import Adapter.Second_Adapter;
import EntityClass.Result;
import EntityClass.Video;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class ForthFragment extends Fragment {
    private  VideoFg_Adapter VideoFg_Adapter ;
    @BindView(R.id.video_rv)
    RecyclerView videoRv;
    Unbinder unbinder;
    private List<Video>videos=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.forth_item,null);
        unbinder = ButterKnife.bind(this, view);




        //创建Retrofit对象
        Retrofit retrofit=new Retrofit.Builder()

                .baseUrl(ApiUrl.APIBAST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        VideoApi request = retrofit.create(VideoApi.class);

        //对 发送请求 进行封装
        Call<Result<Video>> call = request.getCall(getId());

        call.enqueue(new Callback<Result<Video>>() {
            @Override
            public void onResponse(Call<Result<Video>> call, Response<Result<Video>> response) {

                videos = response.body().success;
//                videoRv.setLayoutManager(new LinearLayoutManager(getContext()));

                videoRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                VideoFg_Adapter = new VideoFg_Adapter(videos,getContext());
                videoRv.setAdapter(VideoFg_Adapter);

                Log.e("test", "onResponse: "+videos );

            }

            @Override
            public void onFailure(Call<Result<Video>> call, Throwable t) {

            }
        });


        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class VideoFg_Adapter extends RecyclerView.Adapter<VideoFg_Adapter.ViewHolder> {
        private List<Video>videos=new ArrayList<>();
        Context context;

        public VideoFg_Adapter(List<Video>videos,Context context){

            this.videos=videos;
            this.context=context;


        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private CircleImageView circleImageView;
            private TextView name;
            private TextView source;
            private JCVideoPlayerStandard jcVideoPlayerStandard;



            public ViewHolder(View v) {
                super(v);

                jcVideoPlayerStandard=v.findViewById(R.id.jc_videoview);
                 circleImageView = v.findViewById(R.id.circleImageView);
                 name=v.findViewById(R.id.textView);
                 source=v.findViewById(R.id.textView2);

            }


        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int posation) {


           View v= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video_item, parent, false);
            ViewHolder vh=new ViewHolder(v);

            return vh;

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int posation) {


            Glide.with(ForthFragment.this).load(ApiUrl.HEADBATS + videos.get(posation).getVideoImg()).into(holder.circleImageView);
            holder.name.setText(videos.get(posation).getTitle());
            holder.source.setText(videos.get(posation).getSource());



           holder.jcVideoPlayerStandard.setUp(videos.get(posation).getVideoSrc(), JCVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, videos.get(posation).getTitle());



//            videoFg_viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=new Intent(getActivity(), VideoDetailsActivity.class);
//                    startActivity(intent);
//                }
//            });
            //videoFg_viewHolder.jcVideoPlayerStandard.setUp("http://edge.ivideo.sina.com.cn/6376446.flv?KID=sina,viask&Expires=1546963200&ssig=0yZnm6Rcpw", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频标题");
        }

        @Override
        public int getItemCount() {
            return videos.size();
        }

        public class VideoFg_ViewHolder extends RecyclerView.ViewHolder {

            JCVideoPlayerStandard jcVideoPlayerStandard;
            private CircleImageView circleImageView;
            private TextView name;
            private TextView source;

            public VideoFg_ViewHolder(@NonNull View itemView) {
                super(itemView);





            }
        }

    }

}
