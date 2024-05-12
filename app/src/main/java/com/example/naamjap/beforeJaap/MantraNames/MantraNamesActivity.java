package com.example.naamjap.beforeJaap.MantraNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.naamjap.R;

import java.util.ArrayList;

public class MantraNamesActivity extends AppCompatActivity {
RecyclerView recyclerView ;
ArrayList<MantraNameActivityModel> modelList  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantra_names);
        recyclerView = findViewById(R.id.Rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent i = getIntent();

        modelList.add(new MantraNameActivityModel(i.getStringExtra("mantra1"), i.getIntExtra("mantra1Add"  , -1 )));
        modelList.add(new MantraNameActivityModel(i.getStringExtra("mantra2"), i.getIntExtra("mantra2Add"  , -1 )));
        modelList.add(new MantraNameActivityModel(i.getStringExtra("mantra3"), i.getIntExtra("mantra3Add"  , -1 )));
        modelList.add(new MantraNameActivityModel(i.getStringExtra("mantra4"), i.getIntExtra("mantra4Add"  , -1 )));

        MantraActivityAdapter adapter = new MantraActivityAdapter(this , modelList);
        recyclerView.setAdapter(adapter);
    }
}