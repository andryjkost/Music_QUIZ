package com.example.pril.Solo_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Long_game.Long_game;
import com.example.pril.Progress.MyProgress;
import com.example.pril.R;
import com.example.pril.Sett.Settings;
import com.example.pril.main_menu.Menu;



public class SoloGame_menu extends AppCompatActivity {
    private Toolbar toolbar_solo_menu;
    //кнопки уровней
    Button Solo_first_b;
    Button Solo_second_b;
    Button Solo_third_b;
    Button Solo_for_b;
    Button Solo_first_b1;
    Button Solo_second_b1;
    Button Solo_third_b1;
    Button Solo_for_b1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sologame_menu_activity);
        //создаем тулбар
        toolbar1();
        toolbar();
        //обработка нажатий на кнопки
        Solo_first_b = findViewById(R.id.Solo_first_b);
        Solo_second_b = findViewById(R.id.Solo_second_b);
        Solo_third_b = findViewById(R.id.Solo_third_b);
        Solo_for_b = findViewById(R.id.Solo_for_b);
        Solo_first_b1 = findViewById(R.id.Solo_first_b1);
        Solo_second_b1 = findViewById(R.id.Solo_second_b1);
        Solo_third_b1 = findViewById(R.id.Solo_third_b1);
        Solo_for_b1 = findViewById(R.id.Solo_for_b1);


        //возврат в меню

        Solo_first_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "1");
                startActivity(intent);
                finishAffinity();

            }
        });

        Solo_second_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "2");
                startActivity(intent);
                finishAffinity();
            }
        });
        Solo_third_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "3");
                startActivity(intent);
                finishAffinity();
            }
        });
        Solo_for_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "4");
                startActivity(intent);
                finishAffinity();
            }
        });
        Solo_first_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "5");
                startActivity(intent);
                finishAffinity();

            }
        });

        Solo_second_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "6");
                startActivity(intent);
                finishAffinity();
            }
        });
        Solo_third_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "7");
                startActivity(intent);
                finishAffinity();
            }
        });
        Solo_for_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, SoloGame_zero.class);
                intent.putExtra("VAR", "8");
                startActivity(intent);
                finishAffinity();
            }
        });



    }
    //создание тулбара
    private void toolbar1(){
        ImageButton solo_tool = findViewById(R.id.solo_tul);
        ImageButton solo_long_tool = findViewById(R.id.solo_big_tul);
        ImageButton prog_tool = findViewById(R.id.prog_tul);
        ImageButton mus_tool = findViewById(R.id.mus_tul);

        //быстрая игра
        //не должна нажиматься
        //длинная игра
        solo_long_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, Long_game.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //прогресс
        prog_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, MyProgress.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //музыка
        mus_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_menu.this, Settings.class);
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
                Intent intent = new Intent(SoloGame_menu.this, Menu.class);

                startActivity(intent);
            }
        });
        right_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoloGame_menu.this, "На уровне игры присутствуют 5 вопросов," +
                        " на каждый из которых нужно ответить за 20 секунд", Toast.LENGTH_LONG).show();
            }
        });

    }

}






