package com.elgrande.project.webclient.apiwebclient.weatherclient;

import com.elgrande.project.model.apimodel.WeatherDto;
import com.elgrande.project.webclient.apiwebclient.ApiMetaData;
import com.elgrande.project.webclient.apiwebclient.ApiWebClient;
import com.elgrande.project.webclient.apiwebclient.dto.weatherclientdto.WeatherApiClientDto;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
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

        WeatherApiClientDto response = getApiResponse(this.getUrl(), this.getHeadersData(), this.getParameters());

        WeatherDto weatherDto = WeatherDto.builder()
                .mainParameter(response.getWeather().getMain())
                .description(response.getWeather().getDescription())
                .icon(response.getWeather().getIcon())
                .temperature(response.getMain().getTemp())
                .feelsLike(response.getMain().getFeels_like())
                .pressure(response.getMain().getPressure())
                .humidity(response.getMain().getHumidity())
                .wingSpeed(response.getWind().getSpeed())
                .build();

        return weatherDto;
    }

    private WeatherApiClientDto getApiResponse(String url, Map<String, String> headersData, Map<String, ?> parameters){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        // set `Content-Type` and `Accept` headers
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        for (var entry: headersData.entrySet()) {
            headers.set(entry.getKey(), entry.getValue());
        }

        HttpEntity request = new HttpEntity(headers);

        String linkWithParameters = getLinkWithParameters(url, parameters);

        ResponseEntity<WeatherApiClientDto> response = restTemplate.exchange(
                linkWithParameters,
                HttpMethod.GET,
                request,
                WeatherApiClientDto.class
        );
        System.out.println(response);
        System.out.println(response.toString());
        return response.getBody();
    }

    private String getParametersInLinkTail(Map<String, ?> parameters){
        String tail = "";

        for (var entry: parameters.entrySet()) {
            tail += entry + "&";
        }

        return tail.substring(0,tail.length()-1);
    }

    private String getLinkWithParameters(String url, Map<String, ?> parameters){
        return url + "?" + getParametersInLinkTail(parameters);
    }
}
