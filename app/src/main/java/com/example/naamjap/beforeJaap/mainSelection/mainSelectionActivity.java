package com.example.naamjap.beforeJaap.mainSelection;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


import com.example.naamjap.JapGrah.JapGrah;
import com.example.naamjap.R;
import com.example.naamjap.beforeJaap.MantraNames.MantraNamesActivity;
import com.example.naamjap.beforeJaap.godImages.godImagesActivity;
import com.example.naamjap.beforeJaap.pujaSamgri.pujaActivity;

public class mainSelectionActivity extends AppCompatActivity {
    CardView PujaSamgri  , MantraNames  , GodImages , Done ;
    SharedPreferences sp ;
    SharedPreferences.Editor editor ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
        PujaSamgri = findViewById(R.id.PujaSamagri);
        MantraNames = findViewById(R.id.MantraNames);
        GodImages  = findViewById(R.id.GodImages);
        Done = findViewById(R.id.Done);


        Bundle main = getIntent().getExtras();
        sp = this.getSharedPreferences("mandir" , MODE_PRIVATE);
        editor = sp.edit();



        GodImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mainSelectionActivity.this, godImagesActivity.class);
                if(main.containsKey("image1")){
                Bundle images = new Bundle();
                images.putInt("image1" , main.getInt("image1"));
                images.putInt("image2" , main.getInt("image2"));
                images.putInt("image3" , main.getInt("image3"));
                images.putInt("image4 " , main.getInt("image4"));
                images.putInt("image5" , main.getInt("image5"));
                i.putExtra("images", images);
            }
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        });

        MantraNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(mainSelectionActivity.this , MantraNamesActivity.class);
                if(main.containsKey("mantra1")){
                    i.putExtra("mantra1" ,main.getString("mantra1"));
                    i.putExtra("mantra1Add" , main.getInt("mantra1Add"));
                    i.putExtra("mantra2" ,main.getString("mantra2"));
                    i.putExtra("mantra2Add" , main.getInt("mantra2Add"));
                    i.putExtra("mantra3" ,main.getString("mantra3"));
                    i.putExtra("mantra3Add" , main.getInt("mantra3Add"));
                    i.putExtra("mantra4" ,main.getString("mantra4"));
                    i.putExtra("mantra4Add" , main.getInt("mantra4Add"));
                }
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        PujaSamgri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mainSelectionActivity.this , pujaActivity.class);
                startActivity(i);
            }
        });




        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mainSelectionActivity.this , JapGrah.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle b =  intent.getExtras();
        if(b.containsKey("mantra")){
            editor.putString("mantra" ,b.getString("mantra") );
            editor.putInt("mantraAdd" , b.getInt("mantraAdd"));
            editor.apply();
            editor.commit();
        }

        if(b.containsKey("imageAdd")){
            editor.putInt("image" , b.getInt("imageAdd"));
            editor.apply();
            editor.commit();

        }

    }

}
