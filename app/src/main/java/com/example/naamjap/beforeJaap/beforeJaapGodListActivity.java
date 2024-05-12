package com.example.naamjap.beforeJaap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.naamjap.R;

import java.util.ArrayList;

public class beforeJaapGodListActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<beforeJaapGodListModel> modelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_jaap_god_list);
        recyclerView  = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList.add(new beforeJaapGodListModel("श्री कृष्ण" , " कुंजबिहारी श्री हरिदास " ,R.raw.kunjharidas,
                               "राधा",R.raw.radha ,
                                "हरे कृष्ण हरे कृष्ण ॥ कृष्ण कृष्ण हरे हरे ॥ हरे राम हरे राम ॥ राम राम हरे हरे॥" ,R.raw.harekrishna  ,
                                "कृष्णा" ,R.raw.krishna , R.drawable.krishnaimage1 , R.drawable.krishnaimage2 , R.drawable.krishnaimage3  ,
                                    R.drawable.krishnaimage4 , R.drawable.krishnaimage5));
        beforeJaapGodListAdapter adapter  = new beforeJaapGodListAdapter(this  , modelList);
        recyclerView.setAdapter(adapter);

    }
}