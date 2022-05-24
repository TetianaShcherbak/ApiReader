package com.elgrande.project.webclient.api.webclient.dto.weather.dto;

import lombok.Getter;

@Getter
public class WeatherApiClientDto {
    private WeatherApiClientMainDto main;
    private WeatherApiClientWeatherDto weather;
    private WeatherApiClientWindDto wind;

}
