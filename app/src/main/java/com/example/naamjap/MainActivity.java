package com.example.naamjap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.naamjap.JapGrah.JapGrah;
import com.example.naamjap.beforeJaap.beforeJaapGodListActivity;
import com.example.naamjap.bhajanPlayer.bhajanPLayer;
import com.example.naamjap.chalisa.chalisaSelection;
import com.example.naamjap.profileActivity.profileActivity;
import com.example.naamjap.ramNaam.ramNameWriting;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_PERMISSION_CODE = 123 ;
    TextView musicPlayer, bhajanAlarm, japGrah , chalisa ;
    Button  ramName , naamChamatkar , profile ;
    ToggleButton toggleButton;
    MediaPlayer mp;
    ImageButton onOff;
    private boolean isResume;
    int flag = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        japGrah = findViewById(R.id.JaapGrah);
        bhajanAlarm = findViewById(R.id.BhajanAlarm);
        musicPlayer = findViewById(R.id.BhajanPlayer);
        ramName = findViewById(R.id.naamMahatam);
        naamChamatkar = findViewById(R.id.Naamchamatkar);
        profile = findViewById(R.id.profile);
        chalisa = findViewById(R.id.Chalisa);
        onOff = findViewById(R.id.onOff);






        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String pathMusic = "android.resource://"+getPackageName()+"/raw/lilting";
        Uri uri = Uri.parse(pathMusic);
        try {
            mp.setDataSource(this , uri);
            mp.prepare();
            mp.setLooping(true);
            mp.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

chalisa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this , chalisaSelection.class);
        startActivity( i);
    }
});
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileAct = new Intent(MainActivity.this , profileActivity.class);
                startActivity(profileAct);

            }
        });

        onOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isResume){
                    isResume = true ;
                    onOff.setImageResource(R.drawable.baseline_music_off_24);
                    mp.pause();
                }
                else {
                    isResume = false;
                    onOff.setImageResource(R.drawable.baseline_music_note_24);
                    mp.start();
                }
            }
        });



        japGrah.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i1 = new Intent(MainActivity.this , beforeJaapGodListActivity.class);
        i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i1);
    }
});
bhajanAlarm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i2 = new Intent(MainActivity.this , com.example.naamjap.bhajanAlarm.bhajanAlarm.class);
        startActivity(i2);
    }
});
musicPlayer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i3 = new Intent(MainActivity.this , bhajanPLayer.class);
        startActivity(i3);
    }
});
ramName.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i4 = new Intent(MainActivity.this , ramNameWriting.class);
        startActivity(i4);
    }
});


    }


    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(!isResume){
            mp.start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        // Checking the request code of our request
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == NOTIFICATION_PERMISSION_CODE) {

            // If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                // Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

}