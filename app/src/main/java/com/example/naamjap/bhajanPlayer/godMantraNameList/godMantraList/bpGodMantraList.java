package com.example.naamjap.bhajanPlayer.godMantraNameList.godMantraList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.example.naamjap.R;

import java.io.IOException;
import java.util.ArrayList;

public class bpGodMantraList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<bpGodMantraModel> modelList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpgod_photo_list);

        recyclerView = findViewById(R.id.rvrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent i  = getIntent();
        int imageId = i.getIntExtra("imageAdd" , -1);
        modelList.add(new bpGodMantraModel( i.getStringExtra("mantra1") , i.getIntExtra("mantra1Add" , 0) , imageId) );
        modelList.add(new bpGodMantraModel(i.getStringExtra("mantra2") , i.getIntExtra("mantra2Add" , 0) , imageId));
        modelList.add(new bpGodMantraModel( i.getStringExtra("mantra3") ,i.getIntExtra("mantra3Add" , 0) , imageId));
        bpGodMantraAdapter adapter = new bpGodMantraAdapter(this , modelList);
        recyclerView.setAdapter(adapter);


    }
}