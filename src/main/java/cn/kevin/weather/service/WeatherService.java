package cn.kevin.weather.service;

import cn.kevin.weather.domain.WeatherReport;

public interface WeatherService {

    /**
     * 根据cityId和token获取天气
     * @param cityId 城市id
     * @param token 验证token
     * @return 天气
     */
    WeatherReport getByCityId(String cityId, String token);
}
