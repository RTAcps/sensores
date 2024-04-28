package com.rtacps.sensores.api;

import org.springframework.web.client.RestTemplate;

import com.rtacps.sensores.entities.Sensor;

public class ExternalSensorApiClient {

    private final RestTemplate restTemplate; 
    
    public ExternalSensorApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Sensor fetchData(String sensorName) {
        String url = "http://localhost:5000/api/v1/sensors/{sensorName}"; 
        return restTemplate.getForObject(url, Sensor.class); 
    }
}
