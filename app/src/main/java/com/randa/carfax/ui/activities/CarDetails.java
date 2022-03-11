package com.randa.carfax.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.randa.carfax.databinding.ActivityCarDetailsBinding;
import com.randa.carfax.pojo.Listing;
import com.randa.carfax.ui.adapter.CarAdapter;
import com.squareup.picasso.Picasso;

public class CarDetails extends AppCompatActivity {

    private ActivityCarDetailsBinding binding;
    private Bundle bundle;
    private Listing listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCarDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle=getIntent().getExtras();
        listing= (Listing) bundle.getSerializable("carModel");

        init();
    }

    private void init(){
        binding.location.setText(listing.getDealer().getCity() + " | " +
                listing.getDealer().getState());
        binding.modelView.setText(listing.getYear().toString() + " " +
                listing.getMake() + " " +
                listing.getModel() + " " + listing.getTrim());
        binding.priceMileageView.setText("$ " +listing.getCurrentPrice().toString() +
                "  |  " + listing.getMileage().toString() + " mi");

        Picasso.get().load(listing.getImages().getFirstPhoto().getLarge()).into(binding.imageView);
        binding.bodyStyle.setText(listing.getFuel());
        binding.driveType.setText(listing.getDrivetype());
        binding.engine.setText(listing.getEngine());
        binding.exteriorColor.setText(listing.getExteriorColor());
        binding.interiorColor.setText(listing.getInteriorColor());
        binding.transimsion.setText(listing.getTransmission());
        callDealer(listing.getDealer().getPhone());
    }
    private void callDealer(String phone) {

        binding.callDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + phone));
                v.getContext().startActivity(i);
            }
        });

    }
}