package com.example.naamjap.JapGrah;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naamjap.MainActivity;
import com.example.naamjap.RoomDatabase.databaseModel;
import com.example.naamjap.godMantraList.godMantraList;


import com.example.naamjap.R;

import com.example.naamjap.RoomDatabase.appDatabase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class JapGrah extends AppCompatActivity {
Button reset  ;
ImageButton onoff ;
Button jaapCount;
ImageView photo , bell1 , bell2;
TextView mantraTxt;
private int count  = 0  ;
MediaPlayer lilting , mantraMp , shank , bell ;
TextView    countDisplay;
SimpleDateFormat simpleDate;
SimpleDateFormat simpleTime;
String date  , time ;
Calendar calendar;
SharedPreferences sp;
private boolean isResume;
CardView mantraHolder ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jap_grah);
        declaration();
        mantraTxt.setSelected(true);
        Scroller scroller = new Scroller(this , new LinearInterpolator());



        // Shared Preference
        sp = getSharedPreferences("mandir" , MODE_PRIVATE);
        mantraMp = MediaPlayer.create(this , sp.getInt("mantraAdd" , R.raw.krishna));
        mantraTxt.setText(sp.getString("mantra" , "no mantra selected"));
        photo.setBackgroundResource(sp.getInt("image" , 0 ));

//        Paint textPaint = mantraTxt.getPaint();
//        String text = mantraTxt.getText().toString();//get text
//        int width = Math.round(textPaint.measureText(text));
//        int cardWidth = mantraHolder.getWidth();
//        ViewGroup.LayoutParams params =  mantraTxt.getLayoutParams();
//        params.width = width;
//        mantraTxt.setLayoutParams(params);
//
//        TranslateAnimation animation = new TranslateAnimation(0 , -width , 0 , 0 );
//        animation.setInterpolator(new LinearInterpolator());
//        animation.setDuration(mantraMp.getDuration());
//        animation.setFillAfter(true);
//        animation.setRepeatMode(Animation.RESTART);
//        animation.setRepeatCount(Animation.INFINITE);





        // Media Player
        lilting = MediaPlayer.create(this , R.raw.lilting);
        lilting.setLooping(true);
        lilting.start();
        shank = MediaPlayer.create(this , R.raw.shankh);
        bell = MediaPlayer.create(this , R.raw.bell);





        // DataBase Calling
        appDatabase appDatabase = com.example.naamjap.RoomDatabase.appDatabase.getDb(this);


        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isResume){
                    isResume = true ;
                    onoff.setImageResource(R.drawable.baseline_music_off_24);
                    lilting.pause();
                }
                else {
                    isResume = false;
                    onoff.setImageResource(R.drawable.baseline_music_note_24);
                    lilting.start();
                }
            }
        });

        bell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bell.start();
            }
        });

        bell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bell.start();
            }
        });

       // all the buttons and their on click listeners
        jaapCount.setOnClickListener(v -> {
            count++;
            countDisplay.setText(String.valueOf(count));
            scroller.startScroll(0 , 0 ,100 , 0 ,mantraMp.getDuration() );

            if(mantraMp.isPlaying()){
                mantraMp.seekTo(0);
                mantraMp.start();
            }else {
                mantraMp.start();
            }

        });

        reset.setOnClickListener(v -> {
            timeAndDate();
           appDatabase.dao().InsertInfo(new databaseModel(String.valueOf(count) , date , time , mantraTxt.getText().toString()));
            Toast.makeText(JapGrah.this, date +":" + time , Toast.LENGTH_SHORT).show();
            count = 0 ;
            countDisplay.setText(String.valueOf(count));
        });



    }

    private void declaration() {
        mantraTxt= findViewById(R.id.mantra);
        jaapCount = findViewById(R.id.jaap);
        reset = findViewById(R.id.reset);
        countDisplay = findViewById(R.id.countDisplay);
        bell1 = findViewById(R.id.bell1);
        bell2 = findViewById(R.id.bell2);
        onoff = findViewById(R.id.onoff);
        countDisplay.setText(String.valueOf(count));
        photo = findViewById(R.id.photoFrame);
        count = 0 ;
        mantraHolder = findViewById(R.id.mantraHolder);

    }

    private void timeAndDate() {
        calendar =Calendar.getInstance();
        simpleDate =new SimpleDateFormat("dd-MM-yyyy" , Locale.getDefault());
        date = simpleDate.format(calendar.getTime());
        simpleTime = new SimpleDateFormat("HH:mm:ss" , Locale.getDefault());
        time = simpleTime.format(calendar.getTime());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this ,  MainActivity.class);
        startActivity(i);
        lilting.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        lilting.pause();
        mantraMp.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lilting.start();
    }
}