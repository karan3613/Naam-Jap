package com.example.naamjap.godMantras;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.R;
import com.example.naamjap.bhajanAlarm.bhajanAlarm;

import java.util.ArrayList;

public class godMantrasAdapter extends RecyclerView.Adapter<godMantrasAdapter.ViewHolder> {
    Context context ;
    ArrayList<godMantrasModel> list ;

    public godMantrasAdapter(Context context, ArrayList<godMantrasModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mantras_formantras ,parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getMantra());
        holder.textView.setMovementMethod(new ScrollingMovementMethod());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = holder.getAdapterPosition();
                Intent i = new Intent(context , bhajanAlarm.class);
                i.putExtra("mantra" , list.get(p).getMantra());
                i.putExtra("mantraAdd" , list.get(p).getMantraAdd());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mantraName);

        }
    }
}
