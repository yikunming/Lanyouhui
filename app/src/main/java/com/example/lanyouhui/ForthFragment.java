package com.example.lanyouhui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 易锟铭 on 2019/1/2.
 */

public class ForthFragment extends Fragment {
    @BindView(R.id.video_rv)
    RecyclerView videoRv;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.forth_item,null);
        unbinder = ButterKnife.bind(this, view);
        videoRv.setLayoutManager(new LinearLayoutManager(getContext()));
        videoRv.setAdapter(new VideoFg_Adapter());
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

    public class VideoFg_Adapter extends RecyclerView.Adapter<VideoFg_Adapter.VideoFg_ViewHolder> {



        @NonNull
        @Override
        public VideoFg_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


            return new VideoFg_ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video_item, viewGroup, false));



        }

        @Override
        public void onBindViewHolder(@NonNull VideoFg_ViewHolder videoFg_viewHolder, int i) {
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
            return 10;
        }

        public class VideoFg_ViewHolder extends RecyclerView.ViewHolder {

            JCVideoPlayerStandard jcVideoPlayerStandard;

            public VideoFg_ViewHolder(@NonNull View itemView) {
                super(itemView);
                jcVideoPlayerStandard=itemView.findViewById(R.id.jc_videoview);
                jcVideoPlayerStandard.setUp("http://202.114.51.10/vod.cntv.lxdns.com/flash/mp4video62/TMS/2019/04/12/d59ee81aba1247cb9fe72cb9c948b581_h264418000nero_aac32-1.mp4?wshc_tag=0&wsts_tag=5cbd194d&wsid_tag=79301c6a&wsiphost=ipdbm", JCVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, "视频标题");

            }
        }

    }

}
