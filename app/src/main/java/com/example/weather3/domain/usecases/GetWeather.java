package com.example.weather3.domain.usecases;

import com.example.weather3.domain.WeatherDisplay;
import com.example.weather3.domain.WeatherMapper;
import com.example.weather3.entity.WeatherRepo;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetWeather {

    @Inject WeatherRepo weatherRepo;
    @Inject WeatherMapper mapper;

    public Observable<WeatherDisplay> invoke(String cityName) {
        return weatherRepo.weather(cityName)
                .map(it -> mapper.map(it));
    }
}
