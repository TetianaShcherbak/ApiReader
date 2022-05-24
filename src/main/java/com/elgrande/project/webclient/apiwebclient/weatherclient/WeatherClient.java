package com.elgrande.project.webclient.apiwebclient.weatherclient;

import com.elgrande.project.model.apimodel.WeatherDto;

public interface WeatherClient {

    public WeatherDto getCityWeather(String cityName);
}
