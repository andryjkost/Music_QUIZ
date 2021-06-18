package com.example.pril.Solo_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Long_game.Long_game;
import com.example.pril.R;
import com.example.pril.login.LoginActivity;
import com.example.pril.login.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

//вывод полученных очков
public class SoloGame_itog extends AppCompatActivity {
    private TextView l;
    private TextView p;
    private TextView g;
    private long points1;
    private String points;
    private String level;
    private String game;
    private TextView tv;
    private ImageButton go;
    private FirebaseAuth mAuth;
    private DatabaseReference myDataBase;
    private int level1 = 0;//в зависимости от уровня игры записываем очки в бд в нужный уровень


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sologame_itog);
        l = findViewById(R.id.l);
        g = findViewById(R.id.g);
        p = findViewById(R.id.p);
        go = findViewById(R.id.b_level_menu);
        //получаем очки, левел и раздел игры
        Intent intent = getIntent();
        points = intent.getStringExtra("POINTS");
        points1 = Integer.parseInt(points);
        level = intent.getStringExtra("LEVEL");
        game = intent.getStringExtra("GAME");
        l.setText("УРОВЕНЬ: " + level);
        g.setText("РАЗДЕЛ: " + game);
        p.setText("ОЧКИ: " + points+"/5");
        if (game.equals("ИСТОРИЯ")){//если выбран режим история, то записываем оочки в бд в уровень от пятого до восьмого
            level1 = 4 + Integer.parseInt(level);
        }
        else if (game.equals("ДОЛГАЯ")){
            level1 = 100 + Integer.parseInt(level);
            TextView time = findViewById(R.id.time);
            time.setText("Время: " + intent.getStringExtra("COUNT") + " (сек)");
        }
        else {
            level1 = Integer.parseInt(level);
        }

        //выход в меню
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (game.equals("ДОЛГАЯ")){
                    Intent intent = new Intent(SoloGame_itog.this, Long_game.class);
                    startActivity(intent);
                    finishAffinity();
                }
                else{
                    Intent intent = new Intent(SoloGame_itog.this, SoloGame_menu.class);
                    startActivity(intent);
                    finishAffinity();
                }

            }
        });
        //ключ от бд
        FirebaseUser c = FirebaseAuth.getInstance().getCurrentUser();
        final String st = c.getUid();
        //добавляем к общим баллам очки за этот уровень и в поле этого левела добаляем набранные очки
        FirebaseDatabase.getInstance().getReference("User").child(st).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //количество очков в этом левеле
                long plast = (long) snapshot.child("level_"+String.valueOf(level1)).getValue();
                //сохраняем лучший результат
                if (plast<points1){
                    long p = (long) snapshot.child("all_points").getValue();
                    String name = (String) snapshot.child("email").getValue();
                    if (p==0){
                        FirebaseDatabase.getInstance().getReference("User").child(st).child("all_points").setValue(points1);
                        FirebaseDatabase.getInstance().getReference("User_Progress").child(name.substring(0,name.length()-8)).setValue(points1);
                    }
                    else{
                        FirebaseDatabase.getInstance().getReference("User").child(st).child("all_points").setValue(p+points1-plast);
                        FirebaseDatabase.getInstance().getReference("User_Progress").child(name.substring(0,name.length()-8)).setValue(p+points1-plast);
                    }
                    FirebaseDatabase.getInstance().getReference("User").child(st).child("level_"+String.valueOf(level1)).setValue(points1);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
