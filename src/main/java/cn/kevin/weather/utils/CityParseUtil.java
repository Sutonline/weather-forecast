package cn.kevin.weather.utils;

import cn.kevin.weather.domain.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class CityParseUtil {

    private static volatile Map<String, City> CITY_MAP = new HashMap<>(112777);

    public static City getCity(String cityName) {
        initCityMap();
        return CITY_MAP.get(cityName);
    }

    private static void initCityMap() {
        synchronized (CityParseUtil.class) {
            if (CITY_MAP.isEmpty()) {
                File f = new File(CityParseUtil.class.getClassLoader().getResource("data/city.json").getFile());
                CharSource charSource = Files.asCharSource(f, Charset.forName("UTF-8"));
                try {
                    String content = charSource.read();
                    List<City> cityList = new ObjectMapper().readValue(content, List.class);
                    if (cityList != null && ! cityList.isEmpty()) {
                        CITY_MAP = cityList.stream().collect(
                                Collectors.toMap(City::getName, city -> city));
                    }
                } catch (IOException e) {
                    log.error("解析json格式错误", e);
                    e.printStackTrace();
                }
            }
        }

    }

}
