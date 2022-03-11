package com.randa.carfax.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "Images")
public class Images implements Serializable {


    @SerializedName("firstPhoto")
    @Expose
    @Embedded
    private FirstPhoto firstPhoto;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int image_id;

    public void setFirstPhoto(FirstPhoto firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    public FirstPhoto getFirstPhoto() {
        return firstPhoto;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}


