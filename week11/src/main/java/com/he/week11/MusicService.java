package com.he.week11;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;

public class MusicService extends Service {
    public MusicService() {
    }

    static boolean isplay;
    MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        player=MediaPlayer.create(this,R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!player.isPlaying()){
            player.start();
            isplay=player.isPlaying();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        isplay=player.isPlaying();
        player.release();
        super.onDestroy();
    }
}
