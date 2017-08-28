package cn.kevin.weather;

import cn.kevin.weather.domain.WeatherReport;
import cn.kevin.weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest()
@Slf4j
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void getWeather() throws Exception {
        WeatherReport byCityId = weatherService.getByCityId("beijing", "8f34ad7758c2d530cdbb4979a5de6d9f");
        log.info("获取结果是: {}", byCityId);
    }

    @Test
    public void FormatJson() throws JsonProcessingException {
        WeatherReport weatherReport = new WeatherReport();
        WeatherReport.Weather weather = new WeatherReport.Weather();
        weather.setId("500");
        weather.setMain("Rain");
        weather.setDescription("light rain");
        weather.setIcon("10d");
        ArrayList<WeatherReport.Weather> weatherArrayList = new ArrayList<WeatherReport.Weather>();
        weatherArrayList.add(weather);
        weatherReport.setWeather(weatherArrayList);
        WeatherReport.Main main = new WeatherReport.Main();
        main.setTemp("290.15");
        main.setPressure("1013");
        main.setHumidity("93");
        main.setTemp_min("290.15");
        main.setTemp_max("290.15");
        weatherReport.setMain(main);
        WeatherReport.Wind wind = new WeatherReport.Wind();
        wind.setSpeed("2");
        wind.setDeg("140");
        weatherReport.setWind(wind);
        WeatherReport.Clouds clouds = new WeatherReport.Clouds();
        clouds.setAll("90");
        weatherReport.setClouds(clouds);
        ObjectMapper objectMapper = new ObjectMapper();
        String serilizeJson = objectMapper.writeValueAsString(weatherReport);
        log.info("序列化的结果是: {}", serilizeJson);
    }
}
