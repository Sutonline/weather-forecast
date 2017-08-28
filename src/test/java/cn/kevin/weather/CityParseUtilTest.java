package cn.kevin.weather;

import cn.kevin.weather.domain.City;
import cn.kevin.weather.utils.CityParseUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class CityParseUtilTest {

    @Test
    public void getByName() {
        City beijing = CityParseUtil.getCity("beijing");
        log.info("解析结果是: {}", beijing);
    }

}
