package cn.kevin.weather.service;

import cn.kevin.weather.domain.WeatherReport;

public interface WeatherService {

    /**
     * 根据cityId和token获取天气
     * @param cityName 城市拼音
     * @param token 验证token
     * @return 天气
     */
    WeatherReport getByCityId(String cityName, String token);
}
