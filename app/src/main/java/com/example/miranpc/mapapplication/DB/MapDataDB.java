package com.example.miranpc.mapapplication.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {MapDataModel.class}, version = 1, exportSchema = false)
public abstract class MapDataDB extends RoomDatabase {

    private static final String LOG_TAG = MapDataDB.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "mapdata";
    private static MapDataDB sInstance;

    public static MapDataDB getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        MapDataDB.class, MapDataDB.DATABASE_NAME)
                        .build();
            }
        }
        return sInstance;
    }

    public abstract DataBaseDao mapDao();

}
