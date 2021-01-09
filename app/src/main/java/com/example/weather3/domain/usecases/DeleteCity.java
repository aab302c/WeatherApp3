package com.example.weather3.domain.usecases;

import com.example.weather3.entity.CitiesRepo;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteCity {

    @Inject CitiesRepo citiesRepo;

    public Completable invoke(String city) {
        return citiesRepo.deleteCity(city);
    }
}
