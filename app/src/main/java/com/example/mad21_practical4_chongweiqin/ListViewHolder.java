package com.example.mad21_practical4_chongweiqin;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ListViewHolder extends RecyclerView.ViewHolder{
    TextView list_name, list_description;
    ImageView list_image;
    public ListViewHolder(View view){
        super(view);

        list_name = view.findViewById(R.id.list_name);
        list_description = view.findViewById(R.id.list_description);
        list_image = view.findViewById(R.id.list_image);


    }
}
