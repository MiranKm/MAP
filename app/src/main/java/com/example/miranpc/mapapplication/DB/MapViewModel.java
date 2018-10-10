package com.example.miranpc.mapapplication.DB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MapViewModel extends AndroidViewModel {


    private LiveData<List<MapDataModel>> mapEntityLiveData;

    public MapViewModel(@NonNull Application application) {
        super(application);

        MapDataDB factDB = MapDataDB.getInstance(getApplication().getApplicationContext());
        mapEntityLiveData = factDB.mapDao().getAllData();
    }

    public LiveData<List<MapDataModel>> getMapEntityLiveData() {
        return mapEntityLiveData;
    }


}
