package com.elgrande.project.controller.apicontroller;

import com.elgrande.project.webclient.apiwebclient.weatherclient.WeatherClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elgrande.project.model.apimodel.WeatherDto;
import com.elgrande.project.service.apiservice.WeatherService;

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
