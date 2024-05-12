package com.example.naamjap.bhajanAlarm;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.naamjap.godMantraList.godMantraList;
import com.example.naamjap.R;

import java.io.IOException;
import java.security.Permission;
import java.util.Calendar;
import java.util.Random;

public class bhajanAlarm extends AppCompatActivity implements View.OnClickListener{

Button  setAlarm ,  ChooseMantra ;
    private static final int NOTIFICATION_PERMISSION_CODE = 123 ;
ImageButton timeAlarm ;
EditText startTime , stopTime , setTime  ;
RadioButton oneTime , daily ;
RadioGroup radioGroup ;
private int  mHour, mMinute;
TextView mantraText  ;
    String time ;
    SharedPreferences sp ;
    private int recurringType ;
    private  boolean recurring  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhajan_alarm);
        declaration();
        sp = getSharedPreferences("mandir" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


     Intent intent = getIntent();

     if(intent.hasExtra("mantra")){
         mantraText.setText(intent.getStringExtra("mantra"));
         editor.putInt("mantraAlarm" , R.raw.lilting);
         editor.apply();

     }

     AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup radioGroup, int i) {
          if(i == R.id.daily){
              recurring = true  ;
          }
      }
  });

    ChooseMantra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(bhajanAlarm.this , godMantraList.class);
                startActivity(i);
            }
        });

    setAlarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requestNotificationsPermission();
            }
            String s = setTime.getText().toString();
            if(!s.equals("") && intent.hasExtra("mantraAdd")){
                String[] HandM = s.split(":");
                scheduleAlarm(HandM[0] , HandM[1] , intent.getIntExtra("mantraAdd" , -1 ) );
            }
            else {
                Toast.makeText(bhajanAlarm.this, "please select time or mantra  ", Toast.LENGTH_SHORT).show();
            }


        }
    });
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private void requestNotificationsPermission() {
        if(ContextCompat.checkSelfPermission(this , android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission is already granted", Toast.LENGTH_SHORT).show();
        }
        else {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this , Manifest.permission.POST_NOTIFICATIONS)){
                new AlertDialog.Builder(this)
                        .setTitle("Notification Permission")
                        .setMessage("This permission is needed for alarm to set")
                        .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(bhajanAlarm.this , new String[]{Manifest.permission.POST_NOTIFICATIONS} , NOTIFICATION_PERMISSION_CODE);
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();

            }
            else {
                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.POST_NOTIFICATIONS} , NOTIFICATION_PERMISSION_CODE);
            }
        }
    }

    private void scheduleAlarm(String hour  ,  String minute , int  mantraAdd  ) {
        int alarmId = new Random().nextInt(Integer.MAX_VALUE);

        Alarm alarm = new Alarm(alarmId ,Integer.parseInt(hour) , Integer.parseInt(minute) ,System.currentTimeMillis() ,  true  ,
                recurring , mantraAdd);

        alarm.schedule(this);




    }



    private void declaration() {
        setAlarm = findViewById(R.id.setAlarm);
        timeAlarm = findViewById(R.id.timeAlarm);
        setTime = findViewById(R.id.setTime);
        oneTime = findViewById(R.id.oneTime);
        daily = findViewById(R.id.daily);
        radioGroup = findViewById(R.id.radioGroup);
        ChooseMantra = findViewById(R.id.ChooseMantra);
        mantraText= findViewById(R.id.mantraText);
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

                        time = hourOfDay +":"+ minute;
                        if(v == R.id.timeAlarm){
                            setTime.setText(time);
                        }
                        if(v == R.id.timeStop){
                            stopTime.setText(time);
                        }
                        if(v == R.id.timeStart){
                            startTime.setText(time);
                        }
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
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