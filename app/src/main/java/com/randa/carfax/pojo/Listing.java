package com.randa.carfax.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "Listing")
public class Listing implements Serializable {



    @SerializedName("dealer")
    @Expose
    @Embedded
    private Dealer dealer;


    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int listing_id;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("vin")
    @Expose
    private String vin;

    @SerializedName("year")
    @Expose
    private Integer year;

    @SerializedName("make")
    @Expose
    private String make;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("trim")
    @Expose
    private String trim;

    @SerializedName("mileage")
    @Expose
    private Integer mileage;

    @SerializedName("currentPrice")
    @Expose
    private Double currentPrice;

    @SerializedName("exteriorColor")
    @Expose
    private String exteriorColor;

    @SerializedName("interiorColor")
    @Expose
    private String interiorColor;

    @SerializedName("engine")
    @Expose
    private String engine;


    @SerializedName("drivetype")
    @Expose
    private String drivetype;

    @SerializedName("transmission")
    @Expose
    private String transmission;

    @SerializedName("fuel")
    @Expose
    private String fuel;

    @SerializedName("images")
    @Expose
    @Embedded
    private Images images;

    public Dealer getDealer() {
        return dealer;
    }

    public String getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public Integer getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public String getEngine() {
        return engine;
    }

    public String getDrivetype() {
        return drivetype;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public Images getImages() {
        return images;
    }


    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setDrivetype(String drivetype) {
        this.drivetype = drivetype;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }
}
