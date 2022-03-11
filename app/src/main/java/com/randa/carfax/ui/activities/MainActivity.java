package com.randa.carfax.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.randa.carfax.R;
import com.randa.carfax.databinding.ActivityMainBinding;
import com.randa.carfax.pojo.Listing;
import com.randa.carfax.repository.CarRepository;
import com.randa.carfax.ui.CarViewModels.ViewModelCar;
import com.randa.carfax.ui.adapter.CarAdapter;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ViewModelCar viewModelCar;
    private CarAdapter carAdapter;

    private CarRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModelCar = new ViewModelProvider(this).get(ViewModelCar.class);
        repository = new CarRepository(getApplication());
        checkConnectivity();

    }

    public void retrofitObserve() {
        viewModelCar.getCars();
        carAdapter = new CarAdapter();
        binding.carRecyclerView.setHasFixedSize(true);
        viewModelCar.getListMutableLiveData().observe(this, new Observer<List<Listing>>() {
            @Override
            public void onChanged(List<Listing> listings) {

                carAdapter.setList(listings);

            }
        });

        binding.carRecyclerView.setAdapter(carAdapter);
    }

    public void databaseObserve() {

        carAdapter = new CarAdapter();
        binding.carRecyclerView.setHasFixedSize(true);

        viewModelCar.getAllCar().subscribeOn(Schedulers.computation())
                .subscribe(new Consumer<List<Listing>>() {
                    @Override
                    public void accept(List<Listing> listings) throws Exception {
                        carAdapter.setList(listings);
                    }
                });
        binding.carRecyclerView.setAdapter(carAdapter);
    }

    public void checkConnectivity() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected()) || (mobile != null && mobile.isConnected())) {
            retrofitObserve();
        } else {
            databaseObserve();
        }


    }
}