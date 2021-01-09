package com.example.weather3.domain;

import com.example.weather3.model.Location;

import javax.inject.Inject;

public class LocationMapper extends Mapper<Location, CityDisplay> {

    @Inject
    public LocationMapper() {
    }

    @Override
    protected CityDisplay mapImpl(Location item) {
        return new CityDisplay(item.getName(), item.getCountry());
    }
}
