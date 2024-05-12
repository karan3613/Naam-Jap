package com.example.naamjap.profileActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.naamjap.R;
import com.example.naamjap.RoomDatabase.appDatabase;
import com.example.naamjap.RoomDatabase.databaseModel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class profileActivity extends AppCompatActivity implements calendarRecyclerViewAdapter.onItemClickListener {
RecyclerView calendarRecyclerView;

Button prevMonth , nextMonth  ;
TextView month  ;
LocalDate selectedDate;
ArrayList<databaseModel>  list = new ArrayList<>();
    appDatabase appDatabase ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actitvity);
        declaration();
       appDatabase = com.example.naamjap.RoomDatabase.appDatabase.getDb(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            selectedDate = LocalDate.now();
        }
        setMonthView();

//        databaseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        databaseRecyclerAdapter adapter = new databaseRecyclerAdapter(this , list);
//        databaseRecyclerView.setAdapter(adapter);




    }

    private void setMonthView() {
        month.setText(monthSetupDate(selectedDate));
        ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);
        calendarRecyclerViewAdapter adapter = new calendarRecyclerViewAdapter((Context) this, daysInMonth , this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(adapter);
        prevMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    selectedDate = selectedDate.minusMonths(1);
                }
                setMonthView();
            }
        });
        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    selectedDate = selectedDate.plusMonths(1);
                }
                setMonthView();

            }
        });
    }

    private ArrayList<String> daysInMonthArray(LocalDate selectedDate) {
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            yearMonth = YearMonth.from(selectedDate);
        }

        int daysInMonth = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            daysInMonth = yearMonth.lengthOfMonth();
        }

        LocalDate firstOfMonth = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            firstOfMonth = selectedDate.withDayOfMonth(1);
        }
        int dayOfWeek = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        }

        for(int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                daysInMonthArray.add("");
            }
            else
            {
                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
            }
        }
        return  daysInMonthArray;

    }

    private String monthYearFromDate(LocalDate selectedDate) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM-yyyy");
            return selectedDate.format(formatter);
        }

        return null;
    }
    private String monthSetupDate(LocalDate selectedDate) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MMMM-yyyy");
            return selectedDate.format(formatter);
        }

        return null;
    }

    private void declaration() {
        prevMonth = findViewById(R.id.prevMonth);
        nextMonth = findViewById(R.id.nextMonth);
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        month = findViewById(R.id.month);

    }

    @Override
    public void onItemClick(int position, String dayText) {
        if(!dayText.equals(""))
        {
            String message = dayText + "-" + monthYearFromDate(selectedDate);
            list.addAll(appDatabase.dao().getSelected(message));
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}