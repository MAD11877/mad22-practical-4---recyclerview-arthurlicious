package com.example.mad21_practical23_chongweiqin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);



        ImageView image = (ImageView) findViewById(R.id.activity_list_image);

        image.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ListActivity.this);
                alert.setTitle("Profile");
                alert.setMessage("MADness");
                alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // An intent is an abstract description of an operation to be performed.
                        Intent k = new Intent(ListActivity.this, MainActivity.class);

                        // generate rand no
                        Random rand = new Random();
                        int int_rand = rand.nextInt(10000);

                        // Information can be tagged with the Intent and send across to the receiver
                        // USes key value pair to save data in the intent.
                        k.putExtra("rand", int_rand);
                        startActivity(k);
                    }
                });
                alert.setNegativeButton("Close", null);
                alert.show();
            }
        });


    }
}
