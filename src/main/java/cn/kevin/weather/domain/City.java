package cn.kevin.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class City {

    private String id;
    private String name;
    private String country;

}
