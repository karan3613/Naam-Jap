package com.example.naamjap.ramNaam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.example.naamjap.R;

import java.io.IOException;

public class ramNameWriting extends AppCompatActivity {
MediaPlayer mp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_name_writing);
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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }
}