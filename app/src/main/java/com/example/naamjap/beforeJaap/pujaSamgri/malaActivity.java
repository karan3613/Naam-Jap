package com.example.naamjap.beforeJaap.pujaSamgri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.naamjap.R;

public class malaActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView c1,c2;
    SharedPreferences sp  ;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mala);
        c1 = (CardView) findViewById(R.id.tusli_view);
        c2 = (CardView) findViewById(R.id.rudraksh_view);
        c1.setOnClickListener((View.OnClickListener)this);
        c2.setOnClickListener((View.OnClickListener)this);
        sp = getSharedPreferences("mandir" , MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        if(v.getId()==R.id.tusli_view) {
            i = new Intent(this,pujaActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            editor.putInt("mala" , R.drawable.tm);
            editor.apply();
            editor.commit();
            startActivity(i);

        }
        else{
            i = new Intent(this,pujaActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            editor.putInt("mala" , R.drawable.rm);
            editor.apply();
            editor.commit();
            startActivity(i);
        }

    }
}