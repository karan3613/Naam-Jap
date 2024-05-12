package com.example.naamjap.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {databaseModel.class} , version = 1)
public abstract   class appDatabase  extends RoomDatabase {
    private static  final String DataBaseName = "appDatabase";
    public static appDatabase instance ;
    public static synchronized appDatabase getDb(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context , appDatabase.class , DataBaseName)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  instance ;
    }

    public abstract DAO dao();

}
