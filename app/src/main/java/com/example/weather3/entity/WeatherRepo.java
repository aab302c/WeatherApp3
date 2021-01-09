package com.example.weather3.entity;

import com.example.weather3.model.weather.WeatherObject;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class WeatherRepo {

    @Inject WeatherApiService weatherApiService;

    public Observable<WeatherObject> weather(String cityName) {
        return weatherApiService.getWeather(cityName)
                .subscribeOn(Schedulers.io());
    }
}
