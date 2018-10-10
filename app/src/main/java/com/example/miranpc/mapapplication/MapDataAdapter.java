package com.example.miranpc.mapapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.miranpc.mapapplication.DB.MapDataModel;

import java.util.List;

public class MapDataAdapter extends RecyclerView.Adapter<MapDataAdapter.ViewHolder> {
    private static final String TAG = "MapDataAdapter";
    private Context context;
    private List<MapDataModel> mapDataModelList;

    OnItemClickListener itemClicked;

    public MapDataAdapter(Context context, OnItemClickListener itemClicked) {
        this.context = context;
        this.itemClicked = itemClicked;
    }

    public interface OnItemClickListener {
        void onItemClicked(int pos);


    }

    public void addData(List<MapDataModel> mapDataModels) {
        this.mapDataModelList = mapDataModels;
        Log.d(TAG, "addData: size" + mapDataModelList.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MapDataAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.date.setText(mapDataModelList.get(i).getTime());
            viewHolder.count.setText(String.valueOf(1+i));
            viewHolder.mapData.setText(mapDataModelList.get(i).getLat() + "\n" + mapDataModelList.get(i).getLng());
    }

    @Override
    public int getItemCount() {
        return mapDataModelList == null ? 0 : mapDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView date;
        private TextView mapData;
        private TextView count;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            mapData = itemView.findViewById(R.id.map_data);
            count = itemView.findViewById(R.id.count);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClicked.onItemClicked(getAdapterPosition());
        }
    }
}
