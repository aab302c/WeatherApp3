package com.example.weather3.model.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("humidity")
    @Expose
    private double humidity;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;

    public int getTemp() {
        return (int)temp;
    }

    public int getHumidity() {
        return (int)humidity;
    }
}
