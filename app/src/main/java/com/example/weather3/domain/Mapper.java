package com.example.weather3.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<From, To> {

    public To map(From item) {
        if(item == null) {
            throw new IllegalArgumentException("null argument");
        }
        return mapImpl(item);
    }

    protected abstract To mapImpl(From item);

    public List<To> mapMany(List<From> items) {
        List<To> list = new ArrayList<>();
        for(From item: items){
            list.add(map(item));
        }
        return list;
    }
}
