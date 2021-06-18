package com.example.pril.Solo_game.Third_level;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.R;
import com.example.pril.Solo_game.SoloGame_menu;

public class SoloGame_3_2 extends AppCompatActivity {

        private TextView tv_points;
        private  TextView tv_timer;
        private  TextView tv_quest;
        private TextView tv_rez;
        private RadioButton b1;
        private  RadioButton b2;
        private  RadioButton b3;
        private  RadioButton b4;
        private ImageButton b_next;
        private boolean is_started = true;
        private int count = 20;
        private int points = 0;
        private Button go_ans;
        private String points_st;

        @SuppressLint("SetTextI18n")
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sologame_3_2);
            //Связываем элементы по id
            Intent intent = getIntent();
            points_st = intent.getStringExtra("POINTS");
            points += Integer.parseInt(points_st);
            tv_timer = findViewById(R.id.tv_timer);
            tv_quest = findViewById(R.id.tv_quest);
            tv_points = findViewById(R.id.tv_points);
            tv_rez = findViewById(R.id.tv_rez);
            b1 = findViewById(R.id.b1);
            b2 = findViewById(R.id.b2);
            b3 = findViewById(R.id.b3);
            b4 = findViewById(R.id.b4);
            go_ans = findViewById(R.id.go_ans);
            b_next = findViewById(R.id.b_next);
            //
            toolbar1();
            //вызов и использование элементов






            //ПЕРЕХОД НА СЛЕД ЛЕВЕЛ
            b_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count = 20;
                    is_started = false;
                    Intent intent = new Intent(SoloGame_3_2.this, SoloGame_3_3.class);
                    intent.putExtra("POINTS",String.valueOf(points));
                    startActivity(intent);
                    finishAffinity();

                }
            });
            go_ans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (b1.isChecked() && b3.isChecked() && !b2.isChecked() && !b4.isChecked()){
                        points+=1;
                        b2.setVisibility(View.GONE);
                        b3.setVisibility(View.GONE);
                        b4.setVisibility(View.GONE);
                        b1.setVisibility(View.GONE);
                        go_ans.setVisibility(View.GONE);
                        tv_rez.setVisibility(View.VISIBLE);
                        tv_rez.setText("GOOD");
                        tv_points.setText("Очки: "+String.valueOf(points));
                        Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        b2.setVisibility(View.GONE);
                        b3.setVisibility(View.GONE);
                        b4.setVisibility(View.GONE);
                        b1.setVisibility(View.GONE);
                        go_ans.setVisibility(View.GONE);
                        tv_rez.setVisibility(View.VISIBLE);
                        tv_rez.setText("No...No...");
                        Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                    }

                }
            });


            //вопрос
            tv_quest.setText("Определите все корни уравнения: \n" +
                    "x*x - 9 = 0");
            tv_points.setText("Очки: "+String.valueOf(points));
            Go_thread();






        }
        //ПОТОК

        private void Go_thread(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (is_started){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_timer.setText(String.valueOf(count));

                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (count==0){
                            is_started = false;
                            Intent intent = new Intent(SoloGame_3_2.this, SoloGame_3_3.class);
                            intent.putExtra("POINTS",String.valueOf(points));
                            startActivity(intent);
                            finishAffinity();

                        }

                        count--;
                    }



                }
            }).start();




        }
        //тулбар
        private void toolbar1() {
            ImageView left_icon = findViewById(R.id.left_icon);
            ImageView right_icon = findViewById(R.id.right_icon);


            //кнопкa перехода обратно в меню на тулбаре (слева)
            left_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count = 20;
                    is_started = false;
                    Intent intent = new Intent(SoloGame_3_2.this, SoloGame_menu.class);
                    startActivity(intent);
                    finishAffinity();
                }
            });
        }



    }





