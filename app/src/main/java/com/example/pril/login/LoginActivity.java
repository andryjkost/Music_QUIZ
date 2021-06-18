package com.example.pril.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Solo_game.SoloGame_menu;
import com.example.pril.main_menu.Menu;
import com.example.pril.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {//регистрация, вход
    private EditText edLogin, edPass;
    private FirebaseAuth mAuth;
    private Button bReg, bGo;
    private TextView error;
    private CheckBox eye;
    private DatabaseReference myDataBase;//объект с ссылкой нашей базы данных
    private String USER_KEY = "User";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        edLogin = findViewById(R.id.edLogin);//логин
        edPass = findViewById(R.id.edPass);//пароль
        bReg = findViewById(R.id.bReg);
        bGo = findViewById(R.id.bGo);
        eye = findViewById(R.id.eye);
        error = findViewById(R.id.tv_error);
        myDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);//группа в базе данных будет называться user
        mAuth = FirebaseAuth.getInstance();//иницализация аунтификации
        //пароль виден или нет?
        eye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) edPass.setTransformationMethod(new PasswordTransformationMethod());
                else edPass.setTransformationMethod(null);
                edPass.setSelection(edPass.length());
            }
        });


    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
       FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){//если все введено правильно
            Intent intent = new Intent(LoginActivity.this, Menu.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        }

    }
    public void OnClickSignUp(View view){//регистрируемся
        if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPass.getText().toString())){//проверяем на наличие данных
            mAuth.createUserWithEmailAndPassword(edLogin.getText().toString(),edPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        String id = myDataBase.getKey();
                        String email = edLogin.getText().toString();
                        String password = edPass.getText().toString();
                        User newUser = new User(email, id, password,0,0,0,"0",0,0,0,0,0,0,0);
                        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        myDataBase.child(uid).setValue(newUser);//добавляем в базу данных
                        FirebaseDatabase.getInstance().getReference("User_Progress").child(email.substring(0,email.length()-8)).setValue(0);
                        Intent intent = new Intent(LoginActivity.this, Menu.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Успешная регистрация", Toast.LENGTH_SHORT).show();


                    }
                    else {
                        error.setText("Проверьте введенные данные. Возможно, что вы не подключились\n" +
                                "к интернету или уже зарегистрированы");
                        Toast.makeText(getApplicationContext(), "Регистрация не пройдена", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }
        else {
            Toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_SHORT).show();
        }



    }
    public void OnClickSignIn(View view){//вход
        if (!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPass.getText().toString())) {
            mAuth.signInWithEmailAndPassword(edLogin.getText().toString(),edPass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, Menu.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Успешный вход", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        error.setText("Проверьте введенные данные. Возможно вы не подключились к интернету");
                        Toast.makeText(getApplicationContext(), "Вход не пройден", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }



}
