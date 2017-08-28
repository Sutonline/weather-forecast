package cn.kevin.weather.service.impl;

import cn.kevin.weather.domain.WeatherReport;
import cn.kevin.weather.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private RestTemplate restTemplate;
    private String apiKey;
    private String baseUrl;



    @Override
    public WeatherReport getByCityId(String cityId, String token) {
        WeatherReport weatherReport = null;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(String.format(baseUrl, cityId, apiKey), String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
           String json = responseEntity.getBody();
            try {
                weatherReport = new ObjectMapper().readValue(json, WeatherReport.class);
            } catch (IOException e) {
                log.error("请求cityId: {}天气发生了错误", cityId);
                e.printStackTrace();
            }
        }
        return weatherReport;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value(value = "${openWeather.apiKey}")
    public void setApiKey(String apiKey) {
        Assert.isTrue(! StringUtils.isEmpty(apiKey), "apiKey不能为空!");
        this.apiKey = apiKey;
    }

    @Value(value = "${openWeather.baseUrl}")
    public void setBaseUrl(String baseUrl) {
        Assert.isTrue(! StringUtils.isEmpty(baseUrl), "请求地址不能为空!");
        this.baseUrl = baseUrl;
    }
}
