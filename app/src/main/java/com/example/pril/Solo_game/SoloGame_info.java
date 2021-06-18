package com.example.pril.Solo_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.R;
import com.example.pril.main_menu.Menu;

public class SoloGame_info extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sologame_info);
        toolbar2();
    }


    //создание тулбара
    private void toolbar2(){
        ImageView left_icon = findViewById(R.id.left_icon);
        //кнопкa перехода обратно в меню на тулбаре (слева)
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoloGame_info.this, SoloGame_menu.class);
                startActivity(intent);
            }
        });

    }
}
