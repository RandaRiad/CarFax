package com.randa.carfax.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.lifecycle.LiveData;

import com.randa.carfax.dao.ListingDao;
import com.randa.carfax.database.ListingDataBase;
import com.randa.carfax.pojo.Listing;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class CarRepository {

    public ListingDao listingDao;
    private Flowable<List<Listing>> getAllCars;

    private ListingDataBase listingDataBase;

    public CarRepository(Application application) {
        listingDataBase = ListingDataBase.getInstance(application);
        listingDao = listingDataBase.listingDao();
        getAllCars = listingDao.getAllListing();
    }

    public void insert(List<Listing> cars) {

        listingDao.insert(cars).subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("car", e.getMessage());

                    }
                });
    }

    public Flowable<List<Listing>> getCars() {
        return getAllCars;
    }


    public void delete() {
        listingDao.delete().subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("car", e.getMessage());

                    }
                });
    }


}
