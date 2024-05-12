package com.example.naamjap.godMantras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.naamjap.R;

import java.util.ArrayList;

public class godMantras extends AppCompatActivity {
RecyclerView recyclerView ;
ArrayList<godMantrasModel> modelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_mantras2);
        recyclerView = findViewById(R.id.rvrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent  i= getIntent();
        modelList.add(new godMantrasModel(i.getStringExtra("mantra1") , i.getIntExtra("mantra1Add" , -1)));
        modelList.add(new godMantrasModel(i.getStringExtra("mantra2") , i.getIntExtra("mantra2Add" , -1)));
        modelList.add(new godMantrasModel(i.getStringExtra("mantra3") , i.getIntExtra("mantra3Add" , -1)));
        modelList.add(new godMantrasModel(i.getStringExtra("mantra4") , i.getIntExtra("mantra4Add" , -1)));
        modelList.add(new godMantrasModel(i.getStringExtra("mantra5") , i.getIntExtra("mantra5Add" , -1)));
        godMantrasAdapter adapter = new godMantrasAdapter(this , modelList);
        recyclerView.setAdapter(adapter);

    }
}