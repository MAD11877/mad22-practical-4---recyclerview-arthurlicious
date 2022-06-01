package com.example.mad21_practical4_chongweiqin;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder>{

    ArrayList<List_Item> item;
    public ListAdapter(ArrayList<List_Item> item){
        this.item = item;
    }

    @Override
    public int getItemViewType(int position) {
        List_Item content = item.get(position);
        return (Integer.parseInt(content.name.substring(content.name.length() - 1)) == 7 ? 0 : 1);

    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        if(viewType == 0) {
//            Log.d("ViewType", "VT is null :(");
//            inflater.inflate(R.layout.specialcase_layout, null, false);
//        }
        if (viewType == 1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, null, false);

        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.specialcase_layout, parent, false);

        }



        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        List_Item content = item.get(position);
        holder.list_image.setImageResource(content.images);
        holder.list_name.setText(content.name);
        holder.list_description.setText(content.description);

        Log.d("Last Index", String.valueOf(Integer.parseInt(content.name.substring(content.name.length() - 1))));

        holder.list_image.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("Profile" + content.name);
                alert.setMessage("MADness");
                alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Context context = view.getContext();
                        // An intent is an abstract description of an operation to be performed.
                        Intent k = new Intent(context, MainActivity.class);

//                         Information can be tagged with the Intent and send across to the receiver
//                         USes key value pair to save data in the intent.
                        k.putExtra("name",content.name);
                        k.putExtra("description",content.description);
                        context.startActivity(k);
                    }
                });
                alert.setNegativeButton("Close", null);
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}

