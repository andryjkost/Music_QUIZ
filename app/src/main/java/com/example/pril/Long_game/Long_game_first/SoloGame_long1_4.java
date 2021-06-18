package com.example.pril.Long_game.Long_game_first;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Long_game.Long_game;
import com.example.pril.R;


public class SoloGame_long1_4 extends AppCompatActivity {
    private TextView tv_points;
    private TextView tv_timer;
    private TextView tv_quest;
    private ImageButton b_next;
    private Button go_ans;
    private boolean is_started = true;
    private int count = 0;
    private int points = 0;
    private TextView tv_rez;
    private String points_st;
    private String count_st;
    private EditText ans;

    @SuppressLint("SetTextI18n")//мб здесь ошибка
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sologame_long1_4);
        //Связываем элементы по id
        Intent intent = getIntent();
        points_st = intent.getStringExtra("POINTS");
        count_st = intent.getStringExtra("COUNT");
        points += Integer.parseInt(points_st);
        count += Integer.parseInt(count_st);
        tv_timer = findViewById(R.id.tv_timer);
        tv_quest = findViewById(R.id.tv_quest);
        tv_points = findViewById(R.id.tv_points);
        tv_rez = findViewById(R.id.tv_rez);
        ans = findViewById(R.id.ans);
        b_next = findViewById(R.id.b_next);
        go_ans = findViewById(R.id.go_ans);
        toolbar1();
        //отправляем ответ
        go_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans_st = String.valueOf(ans.getText()).toLowerCase();
                if (ans_st.equals("любовь") || ans_st.equals("любовь ") ||ans_st.equals(" любовь")){
                    ans.setVisibility(View.GONE);
                    go_ans.setVisibility(View.GONE);
                    tv_rez.setVisibility(View.VISIBLE);
                    points+=1;
                    tv_rez.setText("GOOD");
                    tv_points.setText("Очки: "+ String.valueOf(points));
                    Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT).show();
                }
                else {
                    ans.setVisibility(View.GONE);
                    go_ans.setVisibility(View.GONE);
                    tv_rez.setVisibility(View.VISIBLE);
                    tv_rez.setText("No...No...");
                    Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                }

            }
        });



        //ПЕРЕХОД НА СЛЕД ЛЕВЕЛ
        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_started = false;
                Intent intent = new Intent(SoloGame_long1_4.this, SoloGame_long1_5.class);
                intent.putExtra("POINTS", String.valueOf(points));
                intent.putExtra("COUNT", String.valueOf(count));
                startActivity(intent);
                finishAffinity();

            }
        });

        //вопрос
        tv_quest.setText("Как известно, все русские женские имена оканчиваются либо на букву «а», либо на букву «я»:\n" +
                "Анна, Мария, Ирина, Наталья, Ольга и т.д. Однако есть одно-единственное женское имя,\n" +
                "которое  оканчивается на другую букву. Назовите его");
        tv_points.setText("Очки: "+ String.valueOf(points));
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


                    count++;
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
                Intent intent = new Intent(SoloGame_long1_4.this, Long_game.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }



}
