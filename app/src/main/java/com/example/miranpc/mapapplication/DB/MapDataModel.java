package com.example.miranpc.mapapplication.DB;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class MapDataModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String time;
    private double lng;
    private double lat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Ignore
    public MapDataModel(int id, String time, double lng, double lat) {
        this.id = id;
        this.time = time;
        this.lng = lng;
        this.lat = lat;
    }

    public MapDataModel(String time, double lng, double lat) {
        this.time = time;
        this.lng = lng;
        this.lat = lat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    protected MapDataModel(Parcel in) {
        time = in.readString();
        lng = in.readDouble();
        lat = in.readDouble();
    }

    public static final Creator<MapDataModel> CREATOR = new Creator<MapDataModel>() {
        @Override
        public MapDataModel createFromParcel(Parcel in) {
            return new MapDataModel(in);
        }

        @Override
        public MapDataModel[] newArray(int size) {
            return new MapDataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeDouble(lng);
        dest.writeDouble(lat);
    }
}
