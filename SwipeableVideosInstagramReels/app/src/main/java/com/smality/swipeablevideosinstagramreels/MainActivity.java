package com.smality.swipeablevideosinstagramreels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<Video> videos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Videoların FULLSCREEN olarak gösterilmesi için bir kod
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2 = (ViewPager2)findViewById(R.id.viewpager);
        videos = new ArrayList<>();

        Video obj1 = new Video("https://smality.com/Circle-Search-Google.mp4","Circle Search in Google","Circle to Search, only on Android");
        videos.add(obj1);

        Video obj2 = new Video("https://smality.com/Google-AI-Bard.mp4","Using Shorter in Google's AI Bard","Finding the perfect caption can be ruff. \uD83D\uDC3E bard.google.com");
        videos.add(obj2);

        Video obj3 = new Video("https://smality.com/Using-Multisearch-Lens.mp4","Using Multisearch in Lens","It's a date with Lens at @artinstitutechi\n");
        videos.add(obj3);

        Video obj4= new Video("https://smality.com/Google-Career.mp4","Google Career","You are now channeling your potential");
        videos.add(obj4);

        viewPager2.setAdapter(new VideoAdapter(videos));
    }
}