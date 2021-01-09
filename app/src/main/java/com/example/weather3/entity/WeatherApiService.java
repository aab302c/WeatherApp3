package com.example.weather3.entity;

import com.example.weather3.model.weather.WeatherObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WeatherApiService {

    @Headers("x-api-key: f4abe992889a259197385f53aee642ee")
    @GET("data/2.5/weather?units=metric")
    Observable<WeatherObject> getWeather(@Query("q") String city);
}
