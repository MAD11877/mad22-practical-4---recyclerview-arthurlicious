package com.example.mad21_practical23_chongweiqin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button followBtn = (Button) findViewById(R.id.follow);

        User user = new User("Arthur","A quiet reserved individual.",5, false);
        User user1 = new User("Lewis","A quiet reserved individual.",5, false);

        followBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                OnClick(followBtn,user);
            }
        });


        ImageView image_main = (ImageView) findViewById(R.id.image_main);

        image_main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                // An intent is an abstract description of an operation to be performed.
                Intent i = new Intent(MainActivity.this, ListActivity.class);

                // Information can be tagged with the Intent and send across to the receiver
                // USes key value pair to save data in the intent.
                startActivity(i);

            }
        });

        Button message = (Button) findViewById(R.id.message);

        message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent m = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(m);

            }
        });


        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        Integer hello;
        if (extras != null)
        {
            hello = extras.getInt("rand");
            textView2.setText("MAD " + hello);
        }
    }

    public void OnClick(Button button, User u1){

        if(u1.followed == false){
            button.setText("Unfollowed");
            Toast toast = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT);
            toast.show();

            u1.followed = true;
        }else{
            button.setText("Followed");
            Toast toast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
            toast.show();

            u1.followed = false;
        }
    }
}