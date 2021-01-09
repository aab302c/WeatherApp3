package com.example.weather3.app.di;

import com.example.weather3.BuildConfig;
import com.example.weather3.entity.WeatherApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import toothpick.config.Module;

public class NetworkModule extends Module {

    public NetworkModule() {
        WeatherApiService apiService = (new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build())
                .create(WeatherApiService.class);
        bind(WeatherApiService.class).toInstance(apiService);
    }
}

