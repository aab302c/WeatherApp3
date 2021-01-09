package com.example.weather3.domain.usecases;

import com.example.weather3.domain.CityDisplay;
import com.example.weather3.domain.LocationMapper;
import com.example.weather3.entity.CitiesRepo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCities {

    @Inject CitiesRepo citiesRepo;
    @Inject LocationMapper mapper;

    public Observable<List<CityDisplay>> invoke() {
        return citiesRepo.cities()
                .map(it -> mapper.mapMany(it));

    }
}
