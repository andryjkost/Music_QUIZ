package com.example.pril.Solo_game.Music_level_service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.renderscript.ScriptGroup;
import android.text.Layout;
import android.widget.Toast;

import com.example.pril.R;
import com.example.pril.Sett.Settings;

import java.io.File;

public class Music_level_service_2 extends Service {
    private static final String TAG = "MyService";
    private MediaPlayer player;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        player = MediaPlayer.create(this, R.raw.mus_1_2);
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
