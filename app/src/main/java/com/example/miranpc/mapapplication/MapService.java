package com.example.miranpc.mapapplication;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.miranpc.mapapplication.DB.AppExecutors;
import com.example.miranpc.mapapplication.DB.MapDataDB;
import com.example.miranpc.mapapplication.DB.MapDataModel;

import java.util.Calendar;

public class MapService extends IntentService {

    private static final String TAG = "MapService";
    Calendar calendar = Calendar.getInstance();
    MapDataDB mapDataDB;

    public MapService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        String action = intent.getAction();

        mapDataDB = MapDataDB.getInstance(getApplication());
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mapDataDB.mapDao().insertDataToDB(new MapDataModel(calendar.getTime().toString(),
                        intent.getDoubleExtra("lat", 0),
                        intent.getDoubleExtra("lng", 0)));

            }
        });

    }
}
