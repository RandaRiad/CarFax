package com.randa.carfax.ui.adapter;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.randa.carfax.R;
import com.randa.carfax.databinding.CarItemBinding;
import com.randa.carfax.pojo.Listing;
import com.randa.carfax.ui.activities.CarDetails;
import com.randa.carfax.ui.activities.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    List<Listing> list = new ArrayList<>();
    Bundle bundle;

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarViewHolder(CarItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        holder.carItemBinding.locationView.setText(list.get(position).getDealer().getCity() + " | " +
                list.get(position).getDealer().getState());
        holder.carItemBinding.modelView.setText(list.get(position).getYear().toString() + " " +
                list.get(position).getMake() + " " +
                list.get(position).getModel() + " " + list.get(position).getTrim());
        holder.carItemBinding.priceMileageView.setText("$ " + list.get(position).getCurrentPrice().toString() +
                "  |  " + list.get(position).getMileage().toString() + " mi");

        holder.carItemBinding.cardViewCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle=new Bundle();
                bundle.putSerializable("carModel", list.get(position));
                Intent intent=new Intent(v.getContext(), CarDetails.class).putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
        loadImage(list.get(position).getImages().getFirstPhoto().getLarge(), holder);
        callDealer(list.get(position).getDealer().getPhone(), holder);
    }

    private void loadImage(String image, CarViewHolder holder) {
        if (image != null && image != "") {
            Picasso.get().load(image).into(holder.carItemBinding.imageView);

        } else holder.carItemBinding.imageView.setImageResource(R.drawable.picture);

    }

    private void callDealer(String phone, CarViewHolder holder) {

        holder.carItemBinding.callDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + phone));
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Listing> carList) {
        this.list = carList;
        notifyDataSetChanged();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        private CarItemBinding carItemBinding;

        public CarViewHolder(@NonNull CarItemBinding itemView) {
            super(itemView.getRoot());
            this.carItemBinding = itemView;
        }
    }
}
