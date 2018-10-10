package com.example.miranpc.mapapplication.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DataBaseDao {

    @Query("Select * from MapDataModel")
    LiveData<List<MapDataModel>> getAllData();

    @Query("Select * from mapdatamodel where time = :time ")
    MapDataModel getTimeFromDB(String time);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataToDB(MapDataModel mapDataModel);

    @Delete
    void deleteAllRecords(List<MapDataModel> data);

}
