package com.example.naamjap.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DAO {


    @Insert
    public void InsertInfo(databaseModel model);

    @Delete
    public void DeleteInfo(databaseModel model);

    @Update
    public  void  UpdateInfo(databaseModel model);

    @Query("SELECT * FROM  japInfo ")
    public List<databaseModel>  getAll();

    @Query("SELECT * FROM japInfo WHERE DATE(date) = :message")
    public List<databaseModel> getSelected(String message);


}
