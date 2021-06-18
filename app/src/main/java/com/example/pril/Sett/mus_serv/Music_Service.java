package com.example.pril.Sett.mus_serv;

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

public class Music_Service extends Service {
    private static final String TAG = "MyService";
    private MediaPlayer player;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        player = MediaPlayer.create(this, R.raw.music_theme);
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
