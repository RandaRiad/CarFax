package com.randa.carfax.data;

import com.randa.carfax.pojo.CarsModel;
import com.randa.carfax.pojo.Listing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarInterface {


    @GET("assignment.json")
    Call<CarsModel> getAllCars();
}
