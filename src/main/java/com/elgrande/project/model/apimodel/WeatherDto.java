package com.elgrande.project.model.apimodel;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {
    private String mainParameter;
    private String description;
    private String icon;
    private float temperature;
    private float feelsLike;
    private int pressure;
    private int humidity;
    private float wingSpeed;
}
