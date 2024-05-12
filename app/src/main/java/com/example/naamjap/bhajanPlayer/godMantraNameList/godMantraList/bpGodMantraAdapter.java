package com.example.naamjap.bhajanPlayer.godMantraNameList.godMantraList;

import android.content.Context;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.R;
import com.example.naamjap.bhajanPlayer.bhajanPLayer;

import java.util.ArrayList;

public class bpGodMantraAdapter extends RecyclerView.Adapter<bpGodMantraAdapter.viewHolder> {
    Context context ;
    ArrayList<bpGodMantraModel> list ;

    public bpGodMantraAdapter(Context context, ArrayList<bpGodMantraModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mantras_formantras , parent  , false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    holder.textView.setText(list.get(position).getMantraText());
    holder.textView.setMovementMethod(new ScrollingMovementMethod());
    holder.textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int p = holder.getAdapterPosition();
            Intent i = new Intent(context , bhajanPLayer.class);
            i.putExtra("songAdd" , list.get(p).getMantraAdd());
            i.putExtra("imageAdd" , list.get(p).getImageId());
            i.putExtra("songText" , list.get(p).getMantraText());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mantraName);

        }
    }
}
