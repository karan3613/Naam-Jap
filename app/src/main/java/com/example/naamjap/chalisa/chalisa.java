package com.example.naamjap.chalisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.naamjap.R;

public class chalisa extends AppCompatActivity {
    TextView chalisaText ;
Button magnify , demagnify  ;
Float r = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chalisa);
        chalisaText = findViewById(R.id.chalisaText);
        magnify = findViewById(R.id.magnify);
        demagnify = findViewById(R.id.demagnify);
         Intent  i = getIntent();
         chalisaText.setText(i.getStringExtra("Chalisa"));
         chalisaText.setMovementMethod( new ScrollingMovementMethod());
         r  = chalisaText.getTextSize();

         magnify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 chalisaText.setTextSize(++r);
             }
         });
         demagnify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 chalisaText.setTextSize( --r);
             }
         });
    }
}