package com.example.weather3.presentation.weather;

import androidx.lifecycle.ViewModel;

import com.example.weather3.domain.WeatherDisplay;
import com.example.weather3.domain.usecases.AddCity;
import com.example.weather3.domain.usecases.GetWeather;
import com.example.weather3.model.Location;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class WeatherViewModel extends ViewModel {

    @Inject GetWeather getWeather;
    @Inject AddCity addCity;

    @Inject
    public WeatherViewModel() {
    }

    public Observable<WeatherDisplay> getWeather(String city) {
        return getWeather.invoke(city)
                .doOnNext(it -> addCity(new Location(it.getName(), it.getCountry())))
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void addCity(Location location) {
        addCity.invoke(location)
                .subscribe();
    }
}
