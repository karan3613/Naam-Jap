package com.example.naamjap.beforeJaap.pujaSamgri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.naamjap.R;

public class pujaActivity extends AppCompatActivity  implements View.OnClickListener {
    CardView c1,c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puja);


        c1 = (CardView) findViewById(R.id.malaview);
        c2 = (CardView) findViewById(R.id.phoolview);
        c1.setOnClickListener((View.OnClickListener)this);
        c2.setOnClickListener((View.OnClickListener)this);
    }
    @Override
    public void onClick(View v){
        Intent i;
        if(v.getId()==R.id.malaview) {
            i = new Intent(this, malaActivity.class);
            startActivity(i);

        }
        else{
            i = new Intent(this,phoolActivty.class);
            startActivity(i);
        }
    }
}
