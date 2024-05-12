package com.example.naamjap.godMantraList;

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
import com.example.naamjap.godMantras.godMantras;

import java.util.ArrayList;

public class godMantraAdapter extends RecyclerView.Adapter<godMantraAdapter.ViewHolder> {

    Context context ;
    ArrayList<godMantraModel> mantraModels;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mantras_formantras , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.godName.setText(mantraModels.get(position).getName());
        holder.godName.setMovementMethod(new ScrollingMovementMethod());
        holder.godName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = holder.getAdapterPosition();
                    Intent i = new Intent(context , godMantras.class);
                     i.putExtra("mantra1" , mantraModels.get(p).getMantra1());
                     i.putExtra("mantra1Add" , mantraModels.get(p).getMantra1Add());
                     i.putExtra("mantra2" , mantraModels.get(p).getMantra2());
                     i.putExtra("mantra2Add" , mantraModels.get(p).getMantra2Add());
                     i.putExtra("mantra3" , mantraModels.get(p).getMantra3());
                     i.putExtra("mantra3Add" , mantraModels.get(p).getMantra3Add());
                     i.putExtra("mantra4" , mantraModels.get(p).getMantra4());
                     i.putExtra("mantra4Add" , mantraModels.get(p).getMantra4Add());
                     i.putExtra("mantra5" , mantraModels.get(p).getMantra5());
                     i.putExtra("mantra5Add" , mantraModels.get(p).getMantra5Add());
                    context.startActivity(i);

            }
        });

    }

    public godMantraAdapter(Context context, ArrayList<godMantraModel> mantraModels) {
        this.context = context;
        this.mantraModels = mantraModels;
    }

    @Override
    public int getItemCount() {
        return mantraModels.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder {
        TextView godName;
     public ViewHolder(@NonNull View itemView) {
         super(itemView);
         godName = itemView.findViewById(R.id.mantraName);


     }
 }


}
