package com.example.naamjap.beforeJaap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.R;
import com.example.naamjap.beforeJaap.mainSelection.mainSelectionActivity;

import java.util.ArrayList;

public class beforeJaapGodListAdapter extends RecyclerView.Adapter<beforeJaapGodListAdapter.ViewHolder> {
    Context context ;
    ArrayList<beforeJaapGodListModel> list ;

    public beforeJaapGodListAdapter(Context context, ArrayList<beforeJaapGodListModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.before_jaap_custom_design , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getGodName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = holder.getAdapterPosition();
                Intent i =new Intent(context  , mainSelectionActivity.class);
                Bundle main = new Bundle();
                main.putString("mantra1" , list.get(p).getMantra1());
                main.putInt("mantra1Add" , list.get(p).getMantra1Add());
                main.putString("mantra2" , list.get(p).getMantra2());
                main.putInt("mantra2Add" , list.get(p).getMantra2Add());
                main.putString("mantra3" , list.get(p).getMantra3());
                main.putInt("mantra3Add" , list.get(p).getMantra3Add());
                main.putString("mantra4" , list.get(p).getMantra4());
                main.putInt("mantra4Add" , list.get(p).getMantra4Add());
                main.putInt("image1" , list.get(p).getImage1());
                main.putInt("image2" , list.get(p).getImage2());
                main.putInt("image3" , list.get(p).getImage3());
                main.putInt("image4" , list.get(p).getImage4());
                main.putInt("image5" , list.get(p).getImage5());
                i.putExtras(main);
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
            textView = itemView.findViewById(R.id.Name);

        }
    }
}
