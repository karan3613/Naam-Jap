package com.example.naamjap.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "japInfo"  )
public class databaseModel {

    @ColumnInfo(name = "jaapCount")
    private String jaapCount;

    @ColumnInfo(name = "date")
    private String Date;

    @ColumnInfo(name = "time")
    private String time ;

    @ColumnInfo(name = "mantraName")
    private String mantraName ;

    public databaseModel() {
    }

    @Ignore
    public databaseModel(String jaapCount, String date, String time, String mantraName) {
        this.jaapCount = jaapCount;
        Date = date;
        this.time = time;
        this.mantraName = mantraName;
    }

    @Ignore
    public databaseModel(String jaapCount, String date, String time, String mantraName, int id) {
        this.jaapCount = jaapCount;
        Date = date;
        this.time = time;
        this.mantraName = mantraName;
        this.id = id;
    }

    public String getJaapCount() {
        return jaapCount;
    }

    public void setJaapCount(String jaapCount) {
        this.jaapCount = jaapCount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMantraName() {
        return mantraName;
    }

    public void setMantraName(String mantraName) {
        this.mantraName = mantraName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private  int id ;

}
