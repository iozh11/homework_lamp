package com.example.lamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView lamp;
    ImageView background;
    MediaPlayer mp;

    boolean isPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        lamp = findViewById(R.id.lamp);
        background = findViewById(R.id.background);
        mp= MediaPlayer.create(this,R.raw.music);
    }
    public void go(View view) {
        if(!isPlay){
            mp.start();

            background.setBackgroundColor(getColor(R.color.grey));
        }
        else{
            mp.pause();
            background.setBackgroundColor(getColor(R.color.white));
        }
        isPlay = !isPlay;

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isPlay) mp.start();
    }
}