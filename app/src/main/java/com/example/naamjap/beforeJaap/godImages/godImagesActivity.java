package com.example.naamjap.beforeJaap.godImages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.naamjap.beforeJaap.godImages.godPhotos.godPhotosAdapter;
import com.example.naamjap.beforeJaap.godImages.godPhotos.godPhotosModel;
import com.example.naamjap.R;

import java.util.ArrayList;

public class godImagesActivity extends AppCompatActivity {
ArrayList<godPhotosModel> modelList = new ArrayList<>();
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_images);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent i = getIntent();
        Bundle Images = i.getBundleExtra("images");
        if(Images != null) {
            modelList.add(new godPhotosModel(Images.getInt("image1")));
            modelList.add(new godPhotosModel(Images.getInt("image2")));
            modelList.add(new godPhotosModel(Images.getInt("image3")));
            modelList.add(new godPhotosModel(Images.getInt("image4")));
            modelList.add(new godPhotosModel(Images.getInt("image5")));
        }
        godPhotosAdapter  adapter = new godPhotosAdapter(this , modelList);
        recyclerView.setAdapter(adapter);


    }
}