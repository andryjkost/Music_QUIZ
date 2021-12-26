package com.example.pril.Progress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Long_game.Long_game;
import com.example.pril.R;
import com.example.pril.Sett.Settings;
import com.example.pril.Solo_game.SoloGame_menu;
import com.example.pril.main_menu.Menu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProgress extends AppCompatActivity {
    private Button best;
    private TextView inf;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprogress);
        inf = findViewById(R.id.inf);
        //кнопка для показа рейтпнга всех игроков
        best = findViewById(R.id.best);
        best.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProgress.this, Recycler_v.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        final ProgressBar ss = findViewById(R.id.progress_bar);
        final TextView tv = findViewById(R.id.per);

        //ключ от бд
        FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
        final String st = c.getUid();
        FirebaseDatabase.getInstance().getReference("User").child(st).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long per = (long) snapshot.child("all_points").getValue();


                if (per<=100){
                    if (per == 0){
                        ss.setProgress(0);
                    }
                    else{
                        ss.setProgress((int) per);
                    }
                }
                else {
                    ss.setProgress(100);
                }
                inf.setText("Всего очков: "+String.valueOf(per) );
                tv.setText(String.valueOf(per) + "%");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        toolbar3();
        toolbar();
    }


    private void toolbar(){
        ImageView left_icon = findViewById(R.id.left_icon);

        //кнопкa перехода обратно в меню на тулбаре (слева)
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProgress.this, Menu.class);
                startActivity(intent);
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
                Intent intent = new Intent(MyProgress.this, SoloGame_menu.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //длинная игра
        solo_long_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProgress.this, Long_game.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //прогресс
        ///



    }

}
