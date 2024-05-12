package com.example.naamjap.beforeJaap.godImages.godPhotos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.naamjap.R;

import java.util.ArrayList;

public class godPhotos extends AppCompatActivity {
RecyclerView recyclerView ;
ArrayList<godPhotosModel> godImageList = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_photos);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        Intent i = getIntent();
        godImageList.add(new godPhotosModel(i.getIntExtra("image1"  , -1) ));
        godImageList.add(new godPhotosModel(i.getIntExtra("image2" , -1)));
        godImageList.add(new godPhotosModel(i.getIntExtra("image3" , -1)));
        godPhotosAdapter adapter = new godPhotosAdapter(this , godImageList);
        recyclerView.setAdapter(adapter);
    }
}