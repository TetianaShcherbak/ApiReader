package com.elgrande.project.webclient.apiwebclient;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public abstract class ApiWebClient {

    protected ApiMetaData apiMetaData;
    private Map<String, Object> parameters = new HashMap<>();

    public ApiWebClient() {}

    public ApiWebClient(ApiMetaData apiMetaData) {
        this.apiMetaData = apiMetaData;
    }

    public String getUrl() { return apiMetaData.getUrl(); }

    public void setUrl(String url) { this.apiMetaData.setUrl(url); }

    public Map<String, String> getHeadersData() { return apiMetaData.getHeadersData(); }

    public void setHeadersData(Map<String, String> headersData) { this.apiMetaData.setHeadersData(headersData); }

    public Map<String, Object> getParameters() { return parameters; }

    public void setParameters(Map<String, Object> parameters) { this.parameters = parameters; }

    public void addParametersToURL(String key, String value) {
        String url = apiMetaData.getUrl();
        url += "?" + key + "={" + value + "}";
        apiMetaData.setUrl(url);
    }

    public void addParametersToURL(Map<String, String> urlParam) {
        String url = apiMetaData.getUrl();

        for (var entry: urlParam.entrySet()) {
            url += "?" + entry.getKey() + "={" + entry.getValue() + "}";
        }

        apiMetaData.setUrl(url);
    }

    public void addHeadersData(String key, String value) { this.getHeadersData().put(key, value); }

    public void addHeadersData(Map<String, String> headersData){ this.getHeadersData().putAll(headersData);}

    public void addParameters(String key, Object value){ parameters.put(key, value); }

    public void addParameters(Map<String, Object> parameters) { this.parameters.putAll(parameters);}
}
