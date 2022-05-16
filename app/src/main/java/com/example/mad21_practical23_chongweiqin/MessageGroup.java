package com.example.mad21_practical23_chongweiqin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MessageGroup extends AppCompatActivity {

    private fragment_group1 fragment_group1;
    private fragment_group2 fragment_group2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_group);




        Button group1 = (Button) findViewById(R.id.group1);
        Button group2 = (Button) findViewById(R.id.group2);

        group1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fragment_group1 = new fragment_group1();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment_group1).commit();
            }
        });

        group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment_group2 = new fragment_group2();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment_group2).commit();

            }
        });

//
//        // Begin the transaction
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//
//        // Replcae the contents of the container with the new fragment
//        fragmentTransaction.replace(R.id.frame_layout, new fragment_group2());
//
//        // Complete the changes added above
//        fragmentTransaction.commit();
    }
}