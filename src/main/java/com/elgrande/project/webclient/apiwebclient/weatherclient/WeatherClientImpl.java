package com.elgrande.project.webclient.apiwebclient.weatherclient;

import com.elgrande.project.model.apimodel.WeatherDto;
import com.elgrande.project.webclient.apiwebclient.ApiMetaData;
import com.elgrande.project.webclient.apiwebclient.ApiWebClient;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherClientImpl extends ApiWebClient implements WeatherClient {

    public WeatherClientImpl() {
        super(ApiMetaData.WEATHER);
    }

    public WeatherDto getCityWeather(String cityName) {
        Map<String, Object> parameters = new HashMap<>(){{
            put("q", cityName);
        }};
        this.setParameters(parameters);

        JsonObject response = getApiResponse(this.getUrl(), this.getHeadersData(), this.getParameters());
        System.out.println(response);

        WeatherDto weatherDto = getWeatherDto(response);
        System.out.println(weatherDto.toString());

        return weatherDto;
    }

    private WeatherDto getWeatherDto (JsonObject response){
        String mainParameter = getValueByKeyFromJsonObjectInsideJsonArray("main", "weather", response);
        String description = getValueByKeyFromJsonObjectInsideJsonArray("description", "weather", response);
        String icon = getValueByKeyFromJsonObjectInsideJsonArray("icon", "weather", response);

        float temperature = Float.parseFloat(getValueByKeyFromJsonObjectInsideJsonObject("temp", "main", response));
        float feelsLike = Float.parseFloat(getValueByKeyFromJsonObjectInsideJsonObject("feels_like", "main", response));
        int pressure = Integer.parseInt(getValueByKeyFromJsonObjectInsideJsonObject("pressure", "main", response));
        int humidity = Integer.parseInt(getValueByKeyFromJsonObjectInsideJsonObject("humidity", "main", response));

        float wingSpeed = Float.parseFloat(getValueByKeyFromJsonObjectInsideJsonObject("speed", "wind", response));

        WeatherDto weatherDto = WeatherDto.builder()
                .mainParameter(mainParameter)
                .description(description)
                .icon(icon)
                .temperature(temperature)
                .feelsLike(feelsLike)
                .pressure(pressure)
                .humidity(humidity)
                .wingSpeed(wingSpeed)
                .build();

        return weatherDto;
    }
}
