package com.example.naamjap.profileActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.R;
import com.example.naamjap.RoomDatabase.databaseModel;

import java.util.ArrayList;

public class databaseRecyclerAdapter extends RecyclerView.Adapter<databaseRecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<databaseModel> arrayOfBhajanData;
    databaseRecyclerAdapter(Context context , ArrayList<databaseModel> arrayOfBhajanData) {
        this.context = context;
        this.arrayOfBhajanData = arrayOfBhajanData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.database_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Mantra_name.setText(arrayOfBhajanData.get(position).getMantraName());
        holder.date.setText(arrayOfBhajanData.get(position).getDate());
        holder.time.setText(arrayOfBhajanData.get(position).getTime());
        holder.count.setText(String.valueOf(arrayOfBhajanData.get(position).getJaapCount()));
    }

    @Override
    public int getItemCount() {
        return arrayOfBhajanData.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView count,time;
        TextView Mantra_name, date;
        public ViewHolder(View itemView){
            super(itemView);
            Mantra_name  = itemView.findViewById(R.id.nameMantra);
            count = itemView.findViewById(R.id.count);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);


        }

    }


}
