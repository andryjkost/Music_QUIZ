package com.example.pril.login;
public class User {
    public String id, password, email, music;
    public int all_points, level_1, level_2,level_3,level_4,level_5,level_6,level_7,level_8,level_101;


    public User() {
    }

    public User(String email, String id, String password, int all_points, int level_1,  int level_2, String music, int level_3, int level_4, int level_5, int level_6, int level_7, int level_8, int level_101) {
        this.email = email;
        this.password=password;
        this.id=id;
        this.all_points = all_points;
        this.level_1 = level_1;
        this.level_2 = level_2;
        this.level_3 = level_3;
        this.level_4 = level_4;
        this.level_5 = level_5;
        this.level_6 = level_6;
        this.level_7 = level_7;
        this.level_8 = level_8;
        this.level_101 = level_101;

        this.music = music;



    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAll_points() {
        return all_points;
    }






}
