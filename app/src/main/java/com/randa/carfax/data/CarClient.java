package com.randa.carfax.data;

import com.randa.carfax.pojo.CarsModel;
import com.randa.carfax.pojo.Listing;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarClient {

    private CarInterface carInterface;
    private static  CarClient INSTANCE ;

    public CarClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(new Credentials().getBASE_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        carInterface=retrofit.create(CarInterface.class);
    }



    public static CarClient getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new CarClient();
        }
        return INSTANCE;
    }

    public Call<CarsModel> getAllCars(){
        return carInterface.getAllCars();

    }
}
