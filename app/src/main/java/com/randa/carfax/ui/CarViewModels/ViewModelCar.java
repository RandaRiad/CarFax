package com.randa.carfax.ui.CarViewModels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.randa.carfax.data.CarClient;
import com.randa.carfax.pojo.CarsModel;
import com.randa.carfax.pojo.Listing;
import com.randa.carfax.repository.CarRepository;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelCar extends AndroidViewModel {

    private MutableLiveData<List<Listing>> listMutableLiveData = new MutableLiveData<>();

    private CarRepository carRepository;
    private Flowable<List<Listing>> listLiveData;

    public MutableLiveData<List<Listing>> getListMutableLiveData() {
        return listMutableLiveData;
    }


    public void getCars() {

        Call<CarsModel> cars = CarClient.getINSTANCE().getAllCars();
        cars.enqueue(new Callback<CarsModel>() {
            @Override
            public void onResponse(Call<CarsModel> call, Response<CarsModel> response) {
                listMutableLiveData.setValue(response.body().getListings());
                insert(response.body().getListings());
            }

            @Override
            public void onFailure(Call<CarsModel> call, Throwable t) {
                Log.i("Cartag", t.getMessage());

            }
        });
    }

    public ViewModelCar(Application application) {
        super(application);
        carRepository = new CarRepository(application);
        listLiveData = carRepository.getCars();
    }

    public void insert(List<Listing> cars) {

        carRepository.insert(cars);

    }

    public Flowable<List<Listing>> getAllCar() {
        return listLiveData;
    }
}
