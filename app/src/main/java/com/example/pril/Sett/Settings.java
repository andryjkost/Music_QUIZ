package com.example.pril.Sett;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.pril.Long_game.Long_game;
import com.example.pril.Progress.MyProgress;
import com.example.pril.R;
import com.example.pril.Sett.mus_serv.Music_Service;
import com.example.pril.Sett.mus_serv.Music_Service2;
import com.example.pril.Sett.mus_serv.Music_Service3;
import com.example.pril.Sett.mus_serv.Music_Service4;
import com.example.pril.Sett.mus_serv.Music_Service5;
import com.example.pril.Sett.mus_serv.Music_Service6;
import com.example.pril.Sett.mus_serv.Music_Service7;
import com.example.pril.Solo_game.SoloGame_menu;
import com.example.pril.main_menu.Menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.pril.R;
import com.example.pril.main_menu.Menu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {
    public SwitchCompat music_switch;
    public SwitchCompat music_switch2;
    public SwitchCompat music_switch3;
    public SwitchCompat music_switch4;
    public SwitchCompat music_switch5;
    public SwitchCompat music_switch6;
    public SwitchCompat music_switch7;

    public ImageButton error_button2;
    public ImageButton error_button3;
    public ImageButton error_button4;
    public ImageButton error_button5;
    public ImageButton error_button6;
    public ImageButton error_button7;

    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences2;
    SharedPreferences sharedPreferences3;
    SharedPreferences sharedPreferences4;
    SharedPreferences sharedPreferences5;
    SharedPreferences sharedPreferences6;
    SharedPreferences sharedPreferences7;
    MediaPlayer player1;

    boolean prov = true;
    private TextView points_tv;
    public int count = 1;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        points_tv = findViewById(R.id.points);
        toolbar3();
        FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
        final String st = c.getUid();
        //добавляем к общим баллам очки за этот уровень и в поле этого левела добаляем набранные очки
        FirebaseDatabase.getInstance().getReference("User").child(st).child("all_points").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long points = (long) snapshot.getValue();
                points_tv.setText("Очки: "+String.valueOf(points));
                //разблокировка музыки
                if (points < 10) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.GONE);
                    music_switch3.setVisibility(View.GONE);
                    music_switch4.setVisibility(View.GONE);
                    music_switch5.setVisibility(View.GONE);
                    music_switch6.setVisibility(View.GONE);
                    music_switch7.setVisibility(View.GONE);

                    error_button2.setVisibility(View.VISIBLE);
                    error_button3.setVisibility(View.VISIBLE);
                    error_button4.setVisibility(View.VISIBLE);
                    error_button5.setVisibility(View.VISIBLE);
                    error_button6.setVisibility(View.VISIBLE);
                    error_button7.setVisibility(View.VISIBLE);

                } else if (points >= 10 && points < 20) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.VISIBLE);
                    music_switch3.setVisibility(View.GONE);
                    music_switch4.setVisibility(View.GONE);
                    music_switch5.setVisibility(View.GONE);

                    music_switch6.setVisibility(View.GONE);
                    music_switch7.setVisibility(View.GONE);

                    error_button2.setVisibility(View.GONE);
                    error_button3.setVisibility(View.VISIBLE);
                    error_button4.setVisibility(View.VISIBLE);
                    error_button5.setVisibility(View.VISIBLE);
                    error_button6.setVisibility(View.VISIBLE);
                    error_button7.setVisibility(View.VISIBLE);
                } else if (points >= 20 && points < 25) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.VISIBLE);
                    music_switch3.setVisibility(View.VISIBLE);
                    music_switch4.setVisibility(View.GONE);
                    music_switch5.setVisibility(View.GONE);
                    music_switch6.setVisibility(View.GONE);
                    music_switch7.setVisibility(View.GONE);

                    error_button2.setVisibility(View.GONE);
                    error_button3.setVisibility(View.GONE);
                    error_button4.setVisibility(View.VISIBLE);
                    error_button5.setVisibility(View.VISIBLE);
                    error_button6.setVisibility(View.VISIBLE);
                    error_button7.setVisibility(View.VISIBLE);
                } else if (points >= 25 && points < 30) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.VISIBLE);
                    music_switch3.setVisibility(View.VISIBLE);
                    music_switch4.setVisibility(View.VISIBLE);
                    music_switch5.setVisibility(View.GONE);
                    music_switch6.setVisibility(View.GONE);
                    music_switch7.setVisibility(View.GONE);

                    error_button2.setVisibility(View.GONE);
                    error_button3.setVisibility(View.GONE);
                    error_button4.setVisibility(View.GONE);
                    error_button5.setVisibility(View.VISIBLE);
                    error_button6.setVisibility(View.VISIBLE);
                    error_button7.setVisibility(View.VISIBLE);
                } else if (points >= 30 && points < 35) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.VISIBLE);
                    music_switch3.setVisibility(View.VISIBLE);
                    music_switch4.setVisibility(View.VISIBLE);
                    music_switch5.setVisibility(View.VISIBLE);
                    music_switch6.setVisibility(View.GONE);
                    music_switch7.setVisibility(View.GONE);

                    error_button2.setVisibility(View.GONE);
                    error_button3.setVisibility(View.GONE);
                    error_button4.setVisibility(View.GONE);
                    error_button5.setVisibility(View.GONE);
                    error_button6.setVisibility(View.VISIBLE);
                    error_button7.setVisibility(View.VISIBLE);
                } else if (points >= 35 && points < 45) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.VISIBLE);
                    music_switch3.setVisibility(View.VISIBLE);
                    music_switch4.setVisibility(View.VISIBLE);
                    music_switch5.setVisibility(View.VISIBLE);
                    music_switch6.setVisibility(View.VISIBLE);
                    music_switch7.setVisibility(View.GONE);

                    error_button2.setVisibility(View.GONE);
                    error_button3.setVisibility(View.GONE);
                    error_button4.setVisibility(View.GONE);
                    error_button5.setVisibility(View.GONE);
                    error_button6.setVisibility(View.GONE);
                    error_button7.setVisibility(View.VISIBLE);
                } else if (points >= 45) {
                    music_switch.setVisibility(View.VISIBLE);
                    music_switch2.setVisibility(View.VISIBLE);
                    music_switch3.setVisibility(View.VISIBLE);
                    music_switch4.setVisibility(View.VISIBLE);
                    music_switch5.setVisibility(View.VISIBLE);
                    music_switch6.setVisibility(View.VISIBLE);
                    music_switch7.setVisibility(View.VISIBLE);

                    error_button2.setVisibility(View.GONE);
                    error_button3.setVisibility(View.GONE);
                    error_button4.setVisibility(View.GONE);
                    error_button5.setVisibility(View.GONE);
                    error_button6.setVisibility(View.GONE);
                    error_button7.setVisibility(View.GONE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        music_switch = findViewById(R.id.music_switch);
        music_switch2 = findViewById(R.id.music_switch2);
        music_switch3 = findViewById(R.id.music_switch3);
        music_switch4 = findViewById(R.id.music_switch4);
        music_switch5 = findViewById(R.id.music_switch5);
        music_switch6 = findViewById(R.id.music_switch6);
        music_switch7 = findViewById(R.id.music_switch7);

        error_button2 = findViewById(R.id.error_button2);
        error_button3 = findViewById(R.id.error_button3);
        error_button4 = findViewById(R.id.error_button4);
        error_button5 = findViewById(R.id.error_button5);
        error_button6 = findViewById(R.id.error_button6);
        error_button7 = findViewById(R.id.error_button7);
        //создаем и сохраняем switch
        sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        sharedPreferences2 = getSharedPreferences("save2", MODE_PRIVATE);
        sharedPreferences3 = getSharedPreferences("save3", MODE_PRIVATE);
        sharedPreferences4 = getSharedPreferences("save4", MODE_PRIVATE);
        sharedPreferences5 = getSharedPreferences("save5", MODE_PRIVATE);
        sharedPreferences6 = getSharedPreferences("save6", MODE_PRIVATE);
        sharedPreferences7 = getSharedPreferences("save7", MODE_PRIVATE);


        //
        music_switch.setChecked(sharedPreferences.getBoolean("value", false));
        music_switch2.setChecked(sharedPreferences2.getBoolean("value2", false));
        music_switch3.setChecked(sharedPreferences3.getBoolean("value3", false));
        music_switch4.setChecked(sharedPreferences4.getBoolean("value4", false));
        music_switch5.setChecked(sharedPreferences5.getBoolean("value5", false));
        music_switch6.setChecked(sharedPreferences6.getBoolean("value6", false));
        music_switch7.setChecked(sharedPreferences7.getBoolean("value7", false));
        //включаем тулбар
        toolbar();
        //


//реализация включения музыки

//Первая музыка
        music_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//включен
                if (music_switch.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    music_switch.setChecked(true);
                    Intent intent = new Intent(Settings.this, Music_Service.class);
                    startService(intent);
                    //записываем в бд песню, которая была только что выбрана
                    //ключ от бд
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("1");
                    //изменяем в бд записываем музыку, которую нужно играть
                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", false);
                    editor2.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));

                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", false);
                    editor3.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));

                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", false);
                    editor4.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));


                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", false);
                    editor5.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));


                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", false);
                    editor6.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));


                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", false);
                    editor7.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));


                }
//выключен
                else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service.class));
                    //выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    //ключ от бд
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");

                }
            }
        });

//Вторая музыка
        music_switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music_switch2.isChecked()) {


                    //


                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service.class));

                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", false);
                    editor3.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));


                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", false);
                    editor4.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));


                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", false);
                    editor5.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));


                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", false);
                    editor6.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));


                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", false);
                    editor7.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));

                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", true);
                    editor2.apply();
                    music_switch2.setChecked(true);

                    //здесь бд
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("2");
                    Intent intent = new Intent(Settings.this, Music_Service2.class);

                    startService(intent);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor.putBoolean("value2", false);
                    editor.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));
//выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");

//ключ от бд
                }
            }
        });

//Третья музыка
        music_switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music_switch3.isChecked()) {
                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", true);
                    editor3.apply();
                    music_switch3.setChecked(true);
                    Intent intent = new Intent(Settings.this, Music_Service3.class);
                    startService(intent);
                    //здесь бд
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("3");
                    //
                    //

                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    //останавливаю песню, которая не выбрана
                    stopService(new Intent(Settings.this, Music_Service.class));

                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", false);
                    editor2.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));

                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", false);
                    editor4.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));

                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", false);
                    editor5.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));

                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", false);
                    editor6.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));

                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", false);
                    editor7.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));

                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor.putBoolean("value3", false);
                    editor.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));
                    //выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");


                }
            }
        });

        //Четвертая музыка
        music_switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music_switch4.isChecked()) {
                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", true);
                    editor4.apply();
                    music_switch4.setChecked(true);
                    startService(new Intent(Settings.this, Music_Service4.class));
                    //здесь бд
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("4");


                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service.class));

                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", false);
                    editor2.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));

                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", false);
                    editor3.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));

                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", false);
                    editor5.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));

                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", false);
                    editor6.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));

                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", false);
                    editor7.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));

                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor.putBoolean("value4", false);
                    editor.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));
                    //выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");
                }
            }
        });


        music_switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music_switch5.isChecked()) {
                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", true);
                    editor5.apply();
                    music_switch5.setChecked(true);
                    startService(new Intent(Settings.this, Music_Service5.class));

                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("5");


                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service.class));

                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", false);
                    editor2.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));

                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", false);
                    editor3.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));

                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", false);
                    editor4.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));


                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", false);
                    editor6.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));


                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", false);
                    editor7.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));

                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor.putBoolean("value5", false);
                    editor.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");
                    //выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    //ключ от бд
                }
            }
        });


        music_switch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music_switch6.isChecked()) {
                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", true);
                    editor6.apply();
                    music_switch6.setChecked(true);
                    startService(new Intent(Settings.this, Music_Service6.class));
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("6");

                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service.class));

                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", false);
                    editor2.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));


                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", false);
                    editor3.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));


                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", false);
                    editor4.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));


                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", false);
                    editor5.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));


                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", false);
                    editor7.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));

                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor.putBoolean("value6", false);
                    editor.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");

                    //выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    //ключ от бд
                }
            }
        });

        music_switch7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music_switch7.isChecked()) {
                    SharedPreferences.Editor editor7 = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor7.putBoolean("value7", true);
                    editor7.apply();
                    music_switch7.setChecked(true);
                    startService(new Intent(Settings.this, Music_Service7.class));
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("7");


                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    music_switch.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service.class));


                    SharedPreferences.Editor editor2 = getSharedPreferences("save2", MODE_PRIVATE).edit();
                    editor2.putBoolean("value2", false);
                    editor2.apply();
                    music_switch2.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service2.class));

                    SharedPreferences.Editor editor3 = getSharedPreferences("save3", MODE_PRIVATE).edit();
                    editor3.putBoolean("value3", false);
                    editor3.apply();
                    music_switch3.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service3.class));


                    SharedPreferences.Editor editor4 = getSharedPreferences("save4", MODE_PRIVATE).edit();
                    editor4.putBoolean("value4", false);
                    editor4.apply();
                    music_switch4.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service4.class));


                    SharedPreferences.Editor editor5 = getSharedPreferences("save5", MODE_PRIVATE).edit();
                    editor5.putBoolean("value5", false);
                    editor5.apply();
                    music_switch5.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service5.class));


                    SharedPreferences.Editor editor6 = getSharedPreferences("save6", MODE_PRIVATE).edit();
                    editor6.putBoolean("value6", false);
                    editor6.apply();
                    music_switch6.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service6.class));

                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save7", MODE_PRIVATE).edit();
                    editor.putBoolean("value7", false);
                    editor.apply();
                    music_switch7.setChecked(false);
                    stopService(new Intent(Settings.this, Music_Service7.class));
                    FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
                    final String st = c.getUid();
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("music").setValue("0");
                    //выключаем песню и в бд записываем 0 - знак окончания проигрывания музыки
                    //ключ от бд
                }
            }
        });


    }

    private void toolbar() {
        ImageView left_icon = findViewById(R.id.left_icon);
        ImageView right_icon = findViewById(R.id.right_icon);
//кнопкa перехода обратно в меню на тулбаре (слева)
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Menu.class);

                startActivity(intent);
            }
        });
        right_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Settings.this, "Представлена фоновая музыка." +
                        "Чем больше очков, тем больше музыки", Toast.LENGTH_LONG).show();
            }
        });


    }
    private void toolbar3(){
        ImageButton solo_tool = findViewById(R.id.solo_tul);
        ImageButton solo_long_tool = findViewById(R.id.solo_big_tul);
        ImageButton prog_tool = findViewById(R.id.prog_tul);
        ImageButton mus_tool = findViewById(R.id.mus_tul);

        //быстрая игра
        solo_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, SoloGame_menu.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //длинная игра
        solo_long_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Long_game.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //прогресс
        prog_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MyProgress.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //музыка

    }
}