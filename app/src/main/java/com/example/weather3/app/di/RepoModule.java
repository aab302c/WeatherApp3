package com.example.weather3.app.di;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.weather3.entity.CitiesRepo;
import com.example.weather3.entity.database.CitiesDao;
import com.example.weather3.entity.database.CitiesDatabase;

import toothpick.config.Module;

public class RepoModule extends Module {

    public RepoModule(Context context) {
        CitiesDatabase database = Room.databaseBuilder(context, CitiesDatabase.class, "database")
                .build();
        CitiesDao citiesDao = database.getCitiesDao();
        CitiesRepo citiesRepo = new CitiesRepo(citiesDao);
        bind(CitiesRepo.class).toInstance(citiesRepo);
    }
}
