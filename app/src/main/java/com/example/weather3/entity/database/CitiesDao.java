package com.example.weather3.entity.database;

import android.app.Notification;
import android.util.Log;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;


import com.example.weather3.model.Location;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;


@Dao
public interface CitiesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Location location);

    @Query("DELETE FROM location WHERE name LIKE :name")
    void delete(String name);

    @Query("SELECT * FROM location")
    Observable<List<Location>> getLocations();

    @Query("SELECT * FROM location WHERE name LIKE :name")
    Location getLocation(String name);

    default Completable addCity(Location location) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                insert(location);
            }
        });
    }
    default Completable deleteCity(String name) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                delete(name);
            }
        });
    }
}
