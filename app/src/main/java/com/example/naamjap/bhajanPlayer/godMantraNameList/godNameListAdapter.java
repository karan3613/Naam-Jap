package com.example.naamjap.bhajanPlayer.godMantraNameList;

import android.content.Context;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.R;
import com.example.naamjap.bhajanPlayer.godMantraNameList.godMantraList.bpGodMantraList;


import java.util.ArrayList;

public class godNameListAdapter extends RecyclerView.Adapter<godNameListAdapter.ViewHolder>{

    Context context;
    ArrayList<godNameListModel> list;

    public godNameListAdapter(Context context, ArrayList<godNameListModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mantras_formantras , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        holder.textView.setMovementMethod(new ScrollingMovementMethod());
        holder.textView.setOnClickListener(v -> {
            int p = holder.getAdapterPosition();
            Intent i = new Intent(context , bpGodMantraList.class);
            i.putExtra("mantra1" , list.get(p).getMantra1());
            i.putExtra("mantra2" , list.get(p).getMantra2());
            i.putExtra("mantra3"  ,list.get(p).getMantra3());
            i.putExtra("mantra1Add" ,list.get(p).getMantra1Add() );
            i.putExtra("mantra2Add" , list.get(p).getMantra2Add());
            i.putExtra("mantra3Add" , list.get(p).getMantra3Add());
            i.putExtra("imageAdd" , list.get(p).getImageId());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mantraName);
        }
    }

}
