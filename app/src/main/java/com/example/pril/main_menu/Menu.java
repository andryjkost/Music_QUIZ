package com.example.pril.main_menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.pril.Long_game.Long_game;
import com.example.pril.Progress.MyProgress;
import com.example.pril.R;
import com.example.pril.Sett.mus_serv.Music_Service;
import com.example.pril.Sett.Settings;
import com.example.pril.Sett.mus_serv.Music_Service2;
import com.example.pril.Sett.mus_serv.Music_Service3;
import com.example.pril.Sett.mus_serv.Music_Service4;
import com.example.pril.Sett.mus_serv.Music_Service5;
import com.example.pril.Sett.mus_serv.Music_Service6;
import com.example.pril.Sett.mus_serv.Music_Service7;
import com.example.pril.Solo_game.SoloGame_menu;
import com.example.pril.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {
    private ImageButton log_out;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        log_out = findViewById(R.id.log_out1);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Menu.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        //в зависимости от включенной песни проигрываем нужную музыку
        //ключ от бд
        FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
        final String st = c.getUid();
        //изменяем в бд записываем музыку, которую нужно играть
        FirebaseDatabase.getInstance().getReference("User").child(st).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String p = (String) snapshot.child("music").getValue();
                int c = 0;
                if (p.equals("1")){
                    startService(new Intent(Menu.this, Music_Service.class));
                }
                else if (p.equals("2")){
                    startService(new Intent(Menu.this, Music_Service2.class));
                }
                else if (p.equals("3")){
                    startService(new Intent(Menu.this, Music_Service3.class));
                }
                else if (p.equals("4")){
                    startService(new Intent(Menu.this, Music_Service4.class));
                }
                else if (p.equals("5")){
                    startService(new Intent(Menu.this, Music_Service5.class));
                }
                else if (p.equals("6")){
                    startService(new Intent(Menu.this, Music_Service6.class));
                }
                else if (p.equals("7")){
                    startService(new Intent(Menu.this, Music_Service7.class));
                }
                else {
                    c+=1;
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        toolbar3();

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
                Intent intent = new Intent(Menu.this, SoloGame_menu.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //длинная игра
        solo_long_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Long_game.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //прогресс
        prog_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, MyProgress.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //музыка


    }
}
