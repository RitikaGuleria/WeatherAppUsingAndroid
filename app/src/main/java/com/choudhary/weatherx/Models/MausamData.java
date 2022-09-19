package com.choudhary.weatherx.Models;

import java.util.List;

public class MausamData {


    private List<weather>  weather;
    private main main;
    private String name;

    public MausamData(List<com.choudhary.weatherx.Models.weather> weather, com.choudhary.weatherx.Models.main main, String name) {
        this.weather = weather;
        this.main = main;
        this.name = name;
    }

    public List<com.choudhary.weatherx.Models.weather> getWeather() {
        return weather;
    }

    public void setWeather(List<com.choudhary.weatherx.Models.weather> weather) {
        this.weather = weather;
    }

    public com.choudhary.weatherx.Models.main getMain() {
        return main;
    }

    public void setMain(com.choudhary.weatherx.Models.main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
