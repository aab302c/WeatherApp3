package com.example.weather3.presentation.cities;

import androidx.lifecycle.ViewModel;

import com.example.weather3.domain.CityDisplay;
import com.example.weather3.domain.usecases.DeleteCity;
import com.example.weather3.domain.usecases.GetCities;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainViewModel extends ViewModel {

    @Inject GetCities getCities;
    @Inject DeleteCity deleteCity;

    @Inject
    public MainViewModel() {}


    public Observable<List<CityDisplay>> getCities() {
        return getCities.invoke()
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void deleteCity(String cityName) {
        deleteCity.invoke(cityName)
        .subscribe();
    }
}
