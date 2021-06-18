package com.example.pril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pril.login.User;
import com.example.pril.main_menu.Menu;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edName, edSecName, edEmail;
    private DatabaseReference myDataBase;//бъект с ссылкой нашей базы данных
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = findViewById(R.id.edName);
        edSecName = findViewById(R.id.edSecName);
        edEmail = findViewById(R.id.edEMail);
        myDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);//группа в базе данных будет называться user
    }
    public void OnClickSave(View view){//сохраняем все , что вписано в едит текст, для отправки в конструктор
        String id = myDataBase.getKey();
        String name = edName.getText().toString();
        String sec_name = edSecName.getText().toString();
        String email = edEmail.getText().toString();
        User newUser = new User(email, id, name,0,0,0,"0",0,0,0,0,0,0,0);
        if (!TextUtils.isEmpty(name)) {
            myDataBase.push().setValue(newUser);//добавляем в базу данных
        }//проверка наличия текста
        else{
            Toast.makeText(this,"Заполните все данные", Toast.LENGTH_LONG).show();

        }



    }
    public void OnClickOOO(View view){
        Intent intent = new Intent(MainActivity.this, Menu.class);
        startActivity(intent);
    }



}