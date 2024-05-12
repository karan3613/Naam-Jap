package com.example.naamjap.profileActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naamjap.R;

import java.util.ArrayList;

public class calendarRecyclerViewAdapter extends RecyclerView.Adapter<calendarRecyclerViewAdapter.calendarViewHolder>{
    Context context ;
    ArrayList<String> list ;
    private final onItemClickListener onItemClickListener ;

    public calendarRecyclerViewAdapter(Context context, ArrayList<String> list, calendarRecyclerViewAdapter.onItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public calendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.calendarrecyclerdesign , parent , false );
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.height = (int)(parent.getHeight()*0.16666666) ;
        return new calendarViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull calendarViewHolder holder, int position) {
        holder.dayOfMonth.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface onItemClickListener{
        public void onItemClick(int position , String dayText);
    }


    public static class calendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dayOfMonth ;
        TextView calendarCount  ;
        private final onItemClickListener onItemClickListener ;
        public calendarViewHolder(@NonNull View itemView, calendarRecyclerViewAdapter.onItemClickListener onItemClickListener) {
            super(itemView);
            dayOfMonth = itemView.findViewById(R.id.dayOfMonth);
            calendarCount =itemView.findViewById(R.id.calendarCount);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener( this );
        }
        public  void onClick(View view){
            onItemClickListener.onItemClick(getAdapterPosition() , (String)dayOfMonth.getText());

        }
    }

}
