package com.example.mad21_practical4_chongweiqin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);


        ArrayList<List_Item> item = new ArrayList<>();


        // generate rand no
        Random rand = new Random();


        for(int i = 0; i < 100; i++){
//            List_Item list_item = new List_Item(null, null, null);
            int int_rand_name = rand.nextInt(999999999);
            int int_rand_description = rand.nextInt(999999999);
            List_Item list_item = new List_Item();
            list_item.images = android.R.drawable.sym_def_app_icon;
            list_item.name = "Name-" + int_rand_name;
            list_item.description = "Description " + int_rand_description;
            item.add(list_item);
        }


        RecyclerView rv = findViewById(R.id.recyclerView);
        ListAdapter la = new ListAdapter(item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setAdapter(la);
        rv.setLayoutManager(layoutManager);



    }
}