package com.randa.carfax.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.randa.carfax.pojo.Listing;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;


@Dao
public interface ListingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(List<Listing> list);

    @Query("SELECT * FROM Listing")
    Flowable<List<Listing>> getAllListing();

    @Query("DELETE FROM Listing")
    Completable delete ();
}
