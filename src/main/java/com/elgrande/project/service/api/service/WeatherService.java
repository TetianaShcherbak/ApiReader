package com.elgrande.project.service.api.service;

import com.elgrande.project.model.api.model.WeatherDto;
import com.elgrande.project.webclient.api.webclient.weather.WeatherClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClientImpl weatherClient;

    public WeatherDto getWeather(){
        String cityName = "London";
        WeatherDto response = weatherClient.getCityWeather(cityName);
        System.out.println(response.toString());
        return null;
    }
}
