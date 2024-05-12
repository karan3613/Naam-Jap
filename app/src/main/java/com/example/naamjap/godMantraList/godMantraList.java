package com.example.naamjap.godMantraList;

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

public class godMantraList extends AppCompatActivity {
RecyclerView recyclerView ;
ArrayList<godMantraModel> mantras   = new ArrayList<>();
MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_mantra_list);
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String pathMusic = "android.resource://"+getPackageName()+"/raw/bhajgovindam1";
        Uri uri = Uri.parse(pathMusic);
        try {
            mp.setDataSource(this , uri);
            mp.prepare();
            mp.setLooping(true);
            mp.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        recyclerView = findViewById(R.id.rvrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL ,false ));
        mantras.add(new godMantraModel("श्री कृष्ण" , " कुंजबिहारी श्री हरिदास " ,R.raw.kunjharidas,
                "राधा",R.raw.radha ,
                "हरे कृष्ण हरे कृष्ण ॥ कृष्ण कृष्ण हरे हरे ॥ हरे राम हरे राम ॥ राम राम हरे हरे॥" ,R.raw.harekrishna  ,
                "कृष्णा" ,R.raw.krishna  , "radheKrishna" , R.raw.radhekrishna));
        godMantraAdapter adapter = new godMantraAdapter(this ,mantras );
        recyclerView.setAdapter(adapter);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}