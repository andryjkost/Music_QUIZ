package com.example.pril.Long_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Progress.MyProgress;
import com.example.pril.R;
import com.example.pril.Sett.Settings;
import com.example.pril.Solo_game.SoloGame_menu;
import com.example.pril.Solo_game.SoloGame_zero;
import com.example.pril.main_menu.Menu;

public class Long_game extends AppCompatActivity {
    private Button long_game_first_b;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_game_menu);
        long_game_first_b = findViewById(R.id.long_game_first);
        toolbar3();
        toolbar();
        long_game_first_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Long_game.this, SoloGame_zero.class);
                intent.putExtra("VAR", "101");
                startActivity(intent);
                finishAffinity();

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
                Intent intent = new Intent(Long_game.this, SoloGame_menu.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //длинная игра

        //прогресс
        prog_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Long_game.this, MyProgress.class);
                startActivity(intent);
                finishAffinity();
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
                Intent intent = new Intent(Long_game.this, Menu.class);

                startActivity(intent);
            }
        });
        right_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Long_game.this, "Сложные задания без ограничений по времени", Toast.LENGTH_LONG).show();
            }
        });


    }
}
