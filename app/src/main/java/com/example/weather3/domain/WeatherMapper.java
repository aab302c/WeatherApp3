package com.example.weather3.domain;

import com.example.weather3.model.weather.WeatherObject;

import javax.inject.Inject;

public class WeatherMapper extends Mapper<WeatherObject, WeatherDisplay> {

    @Inject
    public WeatherMapper() {
    }

    public WeatherDisplay mapImpl(WeatherObject from) {
        return new WeatherDisplay(
                from.getMain().getTemp(),
                from.getMain().getHumidity(),
                from.getWeather().get(0).getIcon(),
                from.getSys().getSunrise(),
                from.getSys().getSunset(),
                from.getName(),
                from.getSys().getCountry()
        );
    }
}
