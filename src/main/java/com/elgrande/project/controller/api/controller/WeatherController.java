package com.elgrande.project.controller.api.controller;

import com.elgrande.project.webclient.api.webclient.ApiMetaData;
import com.elgrande.project.webclient.api.webclient.weather.WeatherClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elgrande.project.model.api.model.WeatherDto;
import com.elgrande.project.service.api.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/")
    public String test() {
        WeatherClientImpl weatherClient = new WeatherClientImpl();
        System.out.println(weatherClient.getCityWeather("London"));
        return "test";
    }

    @GetMapping("/weather")
    public WeatherDto getWeather(){
        return weatherService.getWeather();
    }
}
