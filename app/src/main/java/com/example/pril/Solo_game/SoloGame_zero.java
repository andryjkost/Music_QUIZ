package com.example.pril.Solo_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Long_game.Long_game_first.SoloGame_long1_1;
import com.example.pril.R;
import com.example.pril.Solo_game.First_level.SoloGame_first_1;
import com.example.pril.Solo_game.Fourth_level.SoloGame_4_1;
import com.example.pril.Solo_game.Hist_First_level.SoloGame_5_1;
import com.example.pril.Solo_game.Hist_Fourth_level.SoloGame_8_1;
import com.example.pril.Solo_game.Hist_Second_level.SoloGame_6_1;
import com.example.pril.Solo_game.Hist_Third_level.SoloGame_7_1;
import com.example.pril.Solo_game.Second_level.SoloGame_second_1;
import com.example.pril.Solo_game.Third_level.SoloGame_3_1;

//отсчет перед началом уровня
public class SoloGame_zero extends AppCompatActivity {
    TextView tv_sologame_zero;
    private boolean is_started = true;
    private int count = 3;
    private String var;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sologame_zero);
        toolbar1();
        tv_sologame_zero = findViewById(R.id.tv_sologame_zero);
        tv_sologame_zero.setText(String.valueOf(count));
        Go_thread();


    }
    private void Go_thread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (is_started) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (count == 0){
                                tv_sologame_zero.setText("GO!");
                            }
                            else {
                                tv_sologame_zero.setText(String.valueOf(count));
                            }


                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 0) {
                        is_started = false;
                        Intent intent = getIntent();
                        var = intent.getStringExtra("VAR");
                        if (var.equals("1")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_first_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("2")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_second_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("3")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_3_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("4")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_4_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("5")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_5_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("6")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_6_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("7")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_7_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("8")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_8_1.class);
                            startActivity(intent1);
                            finishAffinity();
                        }
                        else if (var.equals("101")){
                            Intent intent1 = new Intent(SoloGame_zero.this, SoloGame_long1_1.class);
                            startActivity(intent1);
                            finishAffinity();

                        }


                    }

                    count--;
                }


            }
        }).start();
    }
    private void toolbar1() {
        ImageView left_icon = findViewById(R.id.left_icon);
        ImageView right_icon = findViewById(R.id.right_icon);


        //кнопкa перехода обратно в меню на тулбаре (слева)
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 3;
                is_started = false;
                Intent intent = new Intent(SoloGame_zero.this, SoloGame_menu.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }
}
