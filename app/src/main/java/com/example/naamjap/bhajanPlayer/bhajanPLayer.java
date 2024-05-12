package com.example.naamjap.bhajanPlayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.naamjap.R;

import com.example.naamjap.bhajanAlarm.bhajanAlarm;
import com.example.naamjap.bhajanPlayer.godMantraNameList.godNameList;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class bhajanPLayer extends AppCompatActivity implements View.OnClickListener {

TextView mantra ;
Button start , stop , chooseMantra , timeStart ,timeStop  ;
EditText startTime , stopTime  ;
MediaPlayer mp ;
private int  mHour, mMinute;
String time ;
long stopmillis ,startmillis ,  duration  ;
    TimerTask stopTask ;
     Timer startTimer , stopTimer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhajan_player);
        declaration();
        timeStart.setOnClickListener(this);
        timeStop.setOnClickListener(this);

        stopTimer = new Timer();
        startTimer = new Timer();
        stopTask = new TimerTask() {
            @Override
            public void run() {
                mp.stop();
            }
        };




        chooseMantra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(bhajanPLayer.this , godNameList.class);
                startActivity(i);
            }
        });


        Intent i = getIntent() ;
        if(i.hasExtra("songAdd")) {
            mantra.setText(i.getStringExtra("songText"));
            mp = MediaPlayer.create(this , i.getIntExtra("songAdd" , R.raw.bhajgovindam1));

        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp != null) {
                    if (!mp.isPlaying()) {
                        runTask();
                    }else {
                        Toast.makeText(bhajanPLayer.this, "Already Playing", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(bhajanPLayer.this, " Please Choose Any Mantra", Toast.LENGTH_SHORT).show();

                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp != null) {
                    if (mp.isPlaying()) {
                        mp.stop();
                    } else {
                        Toast.makeText(bhajanPLayer.this, "no music is playing , choose another mantra  ", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(bhajanPLayer.this, "choose mantra ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void runTask() {

        duration = stopmillis - startmillis;
        Toast.makeText(bhajanPLayer.this, "duration :" + duration, Toast.LENGTH_SHORT).show();
        Toast.makeText(bhajanPLayer.this, "time to start :" + (startmillis - System.currentTimeMillis()), Toast.LENGTH_SHORT).show();
        if (duration > 0) {
            TimerTask startTask = new TimerTask() {
                @Override
                public void run() {
                    mp.setLooping(true);
                    mp.start();
                    stopTimer.schedule(stopTask, duration);
                }
            };
            if (startmillis - System.currentTimeMillis() < 0) {
                startTimer.schedule(startTask, 0);

            } else {
                startTimer.schedule(startTask, startmillis - System.currentTimeMillis());
            }
        } else {
            duration = (stopmillis + 86400000) - startmillis;
            TimerTask startTask = new TimerTask() {
                @Override
                public void run() {
                    mp.setLooping(true);
                    mp.start();
                    stopTimer.schedule(stopTask, duration);
                }
            };
            if (startmillis - System.currentTimeMillis() < 0) {
                startTimer.schedule(startTask, 0);

            } else {
                startTimer.schedule(startTask, startmillis - System.currentTimeMillis());
            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mp != null) {
            mp.stop();
        }
    }

    @Override
    public void onClick(View view) {
        int v = view.getId();
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        final Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        time = hourOfDay +":"+ minute;
                        if(v == R.id.timeStop){
                            stopTime.setText(time);
                            stopmillis = calendar.getTimeInMillis();
                            Toast.makeText(bhajanPLayer.this, String.valueOf(stopmillis), Toast.LENGTH_SHORT).show();
                        }
                        if(v == R.id.timeStart){
                            startTime.setText(time);
                            startmillis = calendar.getTimeInMillis();
                            Toast.makeText(bhajanPLayer.this, String.valueOf(startmillis), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void declaration() {
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        mantra = findViewById(R.id.mantraText);
        chooseMantra = findViewById(R.id.chooseMantra);
        timeStart = findViewById(R.id.timeStart);
        timeStop  = findViewById(R.id.timeStop);
        startTime = findViewById(R.id.startTime);
        stopTime = findViewById(R.id.stopTime);
    }
}