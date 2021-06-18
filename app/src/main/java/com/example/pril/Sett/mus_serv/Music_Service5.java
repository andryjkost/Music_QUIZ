package com.example.pril.Sett.mus_serv;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.pril.R;

public class Music_Service5 extends Service {
    private static final String TAG = "MyService";
    private MediaPlayer player;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        player = MediaPlayer.create(this, R.raw.mus_5);
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