package com.smality.swipeablevideosinstagramreels;

import android.media.MediaPlayer;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.viewholder>{
    ArrayList<Video> videos;
    public VideoAdapter(ArrayList<Video> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video,parent,false);
        return new viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.setdata(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        VideoView videoview;
        TextView title,desc;
        ProgressBar probar;
        //Video başlık, açıklama,Videoview gibi elementleri tanımalama
        public viewholder(@NonNull View itemView) {
            super(itemView);
            videoview = itemView.findViewById(R.id.videoview);
            title =itemView.findViewById(R.id.textVideoTitle);
            desc = itemView.findViewById(R.id.textVideoDescription);
            probar = itemView.findViewById(R.id.videoProgressBar);
        }

        void setdata(Video obj){
            videoview.setVideoPath(obj.getUrl());
            title.setText(obj.getTitle());
            desc.setText(obj.getDesc());
            //Video yüklenme anını ProgressBar ile gösterip, videoyu başlatma
            videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    probar.setVisibility(View.INVISIBLE);
                    mediaPlayer.start();
                }
            });

            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
