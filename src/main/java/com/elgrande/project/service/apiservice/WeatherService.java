package com.elgrande.project.service.apiservice;

import com.elgrande.project.model.apimodel.WeatherDto;
import com.elgrande.project.webclient.apiwebclient.weatherclient.WeatherClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClientImpl weatherClient;

    public WeatherDto getWeather(String cityName){
        WeatherDto response = weatherClient.getCityWeather(cityName);
        return response;
    }
}
