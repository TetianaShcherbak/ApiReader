package com.elgrande.project.webclient.api.webclient.weather;

import com.elgrande.project.model.api.model.WeatherDto;

public interface WeatherClient {

    public WeatherDto getCityWeather(String cityName);
}
