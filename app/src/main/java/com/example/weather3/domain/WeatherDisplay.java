package com.example.weather3.domain;

public class WeatherDisplay {

    private int temp;
    private int  humidity;
    private String imageUrl;
    private long sunrise;
    private long sunset;
    private String name;
    private String country;

    public WeatherDisplay(int temp, int humidity, String imageUrl, long sunrise, long sunset, String name, String country) {
        this.temp = temp;
        this.humidity = humidity;
        this.imageUrl = imageUrl;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.name = name;
        this.country = country;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
