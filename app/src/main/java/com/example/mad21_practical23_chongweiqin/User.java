package com.example.mad21_practical23_chongweiqin;

public class User {
    String name;
    String description;
    int id;
    Boolean followed;

    User(String name, String description, int id, Boolean followed){
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }
}