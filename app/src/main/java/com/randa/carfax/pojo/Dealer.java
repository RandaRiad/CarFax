package com.randa.carfax.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
@Entity(tableName = "Dealer")
public class Dealer implements Serializable {


    @SerializedName("carfaxId")
    @Expose
    private String carfaxId;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int dealer_id;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("phone")
    @Expose
    private String phone;


    public String getCarfaxId() {
        return carfaxId;
    }


    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getPhone() {
        return phone;
    }

    public void setCarfaxId(String carfaxId) {
        this.carfaxId = carfaxId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(int dealer_id) {
        this.dealer_id = dealer_id;
    }
}

