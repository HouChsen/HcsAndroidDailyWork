package com.he.week11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageButton playBtn=(ImageButton)findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(MusicService.isplay==false){
                    startService(new Intent(MusicActivity.this,MusicService.class));
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.play,null));
                }else{
                    stopService(new Intent(MusicActivity.this,MusicService.class));
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.stop,null));
                }
            }
        });
    }

    @Override
    protected void onStart() {
        startService(new Intent(MusicActivity.this,MusicService.class));
        super.onStart();
    }
}
