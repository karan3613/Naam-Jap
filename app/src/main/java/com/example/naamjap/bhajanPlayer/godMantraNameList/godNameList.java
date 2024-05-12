package com.example.naamjap.bhajanPlayer.godMantraNameList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.example.naamjap.R;

import java.io.IOException;
import java.util.ArrayList;

public class godNameList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<godNameListModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_name_list);

        recyclerView = findViewById(R.id.recyclerview);
        modelList.add(new godNameListModel("श्री कृष्ण"  , " कुंजबिहारी श्री हरिदास " ,R.raw.kunjharidas,
                "राधा",R.raw.radha ,
                "हरे कृष्ण हरे कृष्ण ॥ कृष्ण कृष्ण हरे हरे ॥ हरे राम हरे राम ॥ राम राम हरे हरे॥" ,R.raw.harekrishna  , R.drawable.krishnablue ));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        godNameListAdapter adapter = new godNameListAdapter(this , modelList);
        recyclerView.setAdapter(adapter);

    }


}