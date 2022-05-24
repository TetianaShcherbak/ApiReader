package com.elgrande.project.webclient.apiwebclient.dto.weatherclientdto;

import lombok.Getter;

@Getter
public class WeatherApiClientDto {
    private WeatherApiClientMainDto main;
    private WeatherApiClientWeatherDto weather;
    private WeatherApiClientWindDto wind;

}
