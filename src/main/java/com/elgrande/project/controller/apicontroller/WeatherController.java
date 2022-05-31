package com.elgrande.project.controller.apicontroller;

import com.elgrande.project.webclient.apiwebclient.weatherclient.WeatherClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.elgrande.project.model.apimodel.WeatherDto;
import com.elgrande.project.service.apiservice.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/")
    public String test() {
        return "test";
    }

    @GetMapping("/weather/{cityName}")
    public WeatherDto getWeather(@PathVariable String cityName){
        return weatherService.getWeather(cityName);
    }
}