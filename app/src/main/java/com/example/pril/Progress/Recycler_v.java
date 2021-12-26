package com.example.pril.Progress;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pril.Long_game.Long_game;
import com.example.pril.R;
import com.example.pril.Sett.Settings;
import com.example.pril.Solo_game.SoloGame_menu;
import com.example.pril.login.LoginActivity;
import com.example.pril.main_menu.Menu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;

public class Recycler_v extends AppCompatActivity {
    private RecyclerView users_list;
    private Users_adapter usersAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_v);
        toolbar();
        toolbar3();

        FirebaseDatabase.getInstance().getReference("User_Progress").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, Integer> mass1 = (HashMap<String, Integer>) snapshot.getValue();

                ArrayList<ArrayList<Object>> mass = new ArrayList<>();

                Iterator<Map.Entry<String, Integer>> iterator = mass1.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    ArrayList <Object> mass_mini = new ArrayList<>();
                    mass_mini.add(entry.getKey());
                    mass_mini.add(entry.getValue());
                    mass.add(mass_mini);

                }
                Collections.sort(mass,new Sort_mass());

                users_list = findViewById(R.id.rv_users);
                //Создаем менеджер
                LinearLayoutManager layoutManager = new LinearLayoutManager(Recycler_v.this);
                users_list.setLayoutManager(layoutManager);
                users_list.setHasFixedSize(true);
                //создание адаптора
                usersAdapter = new Users_adapter(mass.size(), mass);
                users_list.setAdapter(usersAdapter);





            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
    private void toolbar(){
        ImageView left_icon = findViewById(R.id.left_icon);
        ImageView right_icon = findViewById(R.id.right_icon);


        //кнопкa перехода обратно в меню на тулбаре (слева)
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recycler_v.this, MyProgress.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        right_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Recycler_v.this, "Представлен рейтинг всех игроков, отсортированный по общему количеству очков", Toast.LENGTH_LONG).show();
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
                Intent intent = new Intent(Recycler_v.this, SoloGame_menu.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //длинная игра
        solo_long_tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recycler_v.this, Long_game.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        //прогресс
        ///



    }

}
