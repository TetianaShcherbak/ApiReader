package com.elgrande.project.webclient.api.webclient.dto.weather.dto;

import lombok.Getter;

@Getter
public class WeatherApiClientMainDto {
    private float temp;
    private float feels_like;
    private int pressure;
    private int humidity;
}
