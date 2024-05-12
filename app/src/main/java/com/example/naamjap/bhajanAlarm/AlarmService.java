package com.example.naamjap.bhajanAlarm;

import static com.example.naamjap.bhajanAlarm.App.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Vibrator;

import androidx.annotation.IntegerRes;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.naamjap.R;

public class AlarmService extends Service {

    MediaPlayer mp ;
    Vibrator vibrator ;

    @Override
    public void onCreate() {
        super.onCreate();
        myReceiver receiver = new myReceiver() ;



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp = MediaPlayer.create(this , intent.getIntExtra("mantraAdd", R.raw.bhajgovindam1)  );
        mp.setLooping(true);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Intent notificationIntent = new Intent(this, RingActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);



        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("BhajanAlarm")
                .setSmallIcon(R.drawable.musicofff)
                .setContentText("Ring Ring .. Ring Ring")
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1 , notification);

        mp.start();

        long[] pattern = { 0, 100, 1000 };
        vibrator.vibrate(pattern, 0);
        startForeground(1, notification);
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        mp.stop();
        vibrator.cancel();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
