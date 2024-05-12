package com.example.naamjap.bhajanAlarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.SettingInjectorService;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.widget.Toast;

import com.example.naamjap.R;

public class myReceiver extends BroadcastReceiver {

    public   final  static  String RECURRING = "RECURRING";
    public   final  static  String MANTRAADD = "MANTRAADD";


    @Override
    public void onReceive(Context context, Intent intent) {
        String toastText = "Alarm Received";
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        startAlarmService(context , intent , intent.getIntExtra(MANTRAADD , R.raw.bhajgovindam1));

    }


    private void startAlarmService(Context context, Intent intent  , int mantraAdd) {
        Intent intentService = new Intent(context, AlarmService.class);
        intentService.putExtra("mantraAdd" , mantraAdd);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intentService);
        } else {
            context.startService(intentService);
        }
    }

}
