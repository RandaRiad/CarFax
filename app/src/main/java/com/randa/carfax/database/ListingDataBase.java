package com.randa.carfax.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.randa.carfax.dao.ListingDao;
import com.randa.carfax.pojo.Dealer;
import com.randa.carfax.pojo.FirstPhoto;
import com.randa.carfax.pojo.Images;
import com.randa.carfax.pojo.Listing;

import java.util.List;

@Database( entities = {Listing.class, Dealer.class, Images.class, FirstPhoto.class},version = 1)
public abstract class ListingDataBase extends RoomDatabase {

    private static final String DATABASE_NAME="ListingDataBase";
    public abstract ListingDao listingDao();
    private static volatile ListingDataBase INSTANCE;


    public static  ListingDataBase getInstance(Context context){
        if(INSTANCE==null){
            synchronized (ListingDataBase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context, ListingDataBase.class,DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}
