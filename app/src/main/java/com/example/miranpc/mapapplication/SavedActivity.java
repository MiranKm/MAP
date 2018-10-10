package com.example.miranpc.mapapplication;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.miranpc.mapapplication.DB.MapDataModel;
import com.example.miranpc.mapapplication.DB.MapViewModel;

import java.util.List;

public class SavedActivity extends AppCompatActivity implements MapDataAdapter.OnItemClickListener {
    private static final String TAG = "SavedActivity";
    RecyclerView savedRecycler;
    MapDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        savedRecycler = findViewById(R.id.recycler);
        makeSavedRecycler();

        MapViewModel mapViewModel = new MapViewModel(getApplication());
        mapViewModel.getMapEntityLiveData().observe(this, new Observer<List<MapDataModel>>() {
            @Override
            public void onChanged(@Nullable List<MapDataModel> mapDataModels) {
                adapter.addData(mapDataModels);
                Toast.makeText(SavedActivity.this, "size"+ adapter.getItemCount(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "database size:  " + adapter.getItemCount());
            }
        });

    }


    private void makeSavedRecycler() {
        savedRecycler.setHasFixedSize(true);
        savedRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MapDataAdapter(this, this);
        savedRecycler.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int pos) {

    }
}
