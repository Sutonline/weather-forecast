package cn.kevin.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 天气实体
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherReport {

    @JsonProperty(value = "id")
    private String cityId;
    private String name;
    private Date dt;
    @JsonProperty(value = "weather")
    private List<Weather> weather;
    @JsonProperty(value = "main")
    private Main main;
    @JsonProperty(value = "wind")
    private Wind wind;
    @JsonProperty(value = "clouds")
    private Clouds clouds;
    @JsonProperty(value = "rain")
    private Rain rain;
    @JsonProperty(value = "snow")
    private Snow snow;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        @JsonProperty(value = "id")
        private String id;
        @JsonProperty(value = "main")
        private String main;
        @JsonProperty(value = "description")
        private String description;
        @JsonProperty(value = "icon")
        private String icon;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        @JsonProperty("temp")
        private String temp;
        @JsonProperty("pressure")
        private String pressure;
        @JsonProperty("humidity")
        private String humidity;
        @JsonProperty("temp_min")
        private String temp_min;
        @JsonProperty("temp_max")
        private String temp_max;
        @JsonProperty("sea_level")
        private String seal_level;
        @JsonProperty("grnd_level")
        private String grnd_level;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind {
        @JsonProperty("speed")
        private String speed;
        @JsonProperty("deg")
        private String deg;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Clouds {
        @JsonProperty("all")
        private String all;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rain {
        @JsonProperty("3h")
        private String rainVolume;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Snow {
        @JsonProperty(value = "3h")
        private String snowVolume;
    }



}
