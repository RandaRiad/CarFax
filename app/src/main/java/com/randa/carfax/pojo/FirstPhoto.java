package com.randa.carfax.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
@Entity(tableName = "FirstPhoto")
public class FirstPhoto implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int photo_id;

    @SerializedName("large")
    @Expose
   // @ColumnInfo(name="large")
    private String large;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }
}
