package com.example.naamjap.beforeJaap.pujaSamgri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.naamjap.R;

public class phoolActivty extends AppCompatActivity implements View.OnClickListener {
    CardView c1,c2,c3;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phool_activty);
        c1 = (CardView) findViewById(R.id.gulab_view);
        c2 = (CardView) findViewById(R.id.tulsipatra_view);
        c3 = (CardView) findViewById(R.id.belpatra_view);
        c1.setOnClickListener((View.OnClickListener)this);
        c2.setOnClickListener((View.OnClickListener)this);
        c3.setOnClickListener((View.OnClickListener)this);
        sp = getSharedPreferences("mandir" , MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        if(v.getId()==R.id.gulab_view) {
            i = new Intent(this, pujaActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            editor.putInt("mala" , R.drawable.gulabphool);
            editor.apply();
            editor.commit();

            startActivity(i);

        }
        else if(v.getId()==R.id.tulsipatra_view){
            i = new Intent(this, pujaActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            editor.putInt("mala" , R.drawable.tulsiphool);
            editor.apply();
            editor.commit();
            startActivity(i);
        }
        else{
            i = new Intent(this,pujaActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            editor.putInt("mala" , R.drawable.belpatraphool);
            editor.apply();
            editor.commit();
            startActivity(i);

        }
    }
}
