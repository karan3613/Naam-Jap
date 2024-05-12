package com.example.naamjap.beforeJaap.godImages.godPhotos;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.JapGrah.JapGrah;
import com.example.naamjap.R;
import com.example.naamjap.beforeJaap.mainSelection.mainSelectionActivity;

import java.util.ArrayList;

public class godPhotosAdapter extends RecyclerView.Adapter<godPhotosAdapter.ViewHolder> {
    Context context;
    ArrayList<godPhotosModel> godPhotos;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(context).inflate(R.layout.god_photos , parent   ,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.imageView.setBackgroundResource(godPhotos.get(position).getImage());
    holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int p = holder.getAdapterPosition();
        Intent i = new Intent(context , mainSelectionActivity.class);
        Bundle image = new Bundle();
        image.putInt("imageAdd" , godPhotos.get(p).getImage());
        i.putExtras(image);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
       // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(i);



    }
});
    }



    @Override
    public int getItemCount() {
        return godPhotos.size();
    }

    public  static  class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView  ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }

    public godPhotosAdapter(Context context, ArrayList<godPhotosModel> godList) {

        this.context = context;
        this.godPhotos = godList;
    }

}
