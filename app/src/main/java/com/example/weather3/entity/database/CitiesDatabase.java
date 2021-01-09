package com.example.weather3.entity.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.weather3.model.Location;

@Database(entities = {Location.class}, version = 1)
public abstract class CitiesDatabase extends RoomDatabase {

    public abstract CitiesDao getCitiesDao();
}
