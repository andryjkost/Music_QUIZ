package com.example.pril.Solo_game.Music_level_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.pril.R;

public class Music_level_service_17 extends Service {
    private static final String TAG = "MyService";
    private MediaPlayer player;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        player = MediaPlayer.create(this, R.raw.mus_4_2);
        player.setLooping(true); // зацикливаем
    }

    @Override
    public void onDestroy() {

        player.stop();
    }

    @Override
    public void onStart(Intent intent, int startid) {

        player.start();
    }
}