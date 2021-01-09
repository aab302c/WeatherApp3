package com.example.weather3.entity;

import android.util.Log;

import com.example.weather3.app.App;
import com.example.weather3.entity.database.CitiesDao;
import com.example.weather3.entity.database.CitiesDatabase;
import com.example.weather3.model.Location;
import com.example.weather3.model.weather.WeatherObject;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CitiesRepo {

    private CitiesDao citiesDao;
    private Observable<List<Location>> citiesList;

    @Inject
    public CitiesRepo(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
        citiesList = citiesDao.getLocations()
                .subscribeOn(Schedulers.io());
    }

    public Observable<List<Location>> cities() {
        return citiesList;
    }

    public Completable addCity(Location location) {
        return citiesDao.addCity(location)
                .subscribeOn(Schedulers.io());
    }

    public Completable deleteCity(String city) {
        return citiesDao.deleteCity(city)
                .subscribeOn(Schedulers.io());
    }
}
