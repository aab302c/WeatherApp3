package com.example.weather3.domain.usecases;

import com.example.weather3.entity.CitiesRepo;
import com.example.weather3.model.Location;

import javax.inject.Inject;

import io.reactivex.Completable;

public class AddCity {

    @Inject CitiesRepo citiesRepo;

    public Completable invoke(Location location) {
        return citiesRepo.addCity(location);
    }
}
