package bid.adonis.lau.service.impl;

import bid.adonis.lau.entity.City;
import bid.adonis.lau.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/9 15:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityService cityService;

    @Test
    public void findCityById() throws Exception {

        City city = new City();
        city.setCityName("上海");
        city.setDescription("ShangHai");
        city.setProvinceId(2L);
        cityService.saveCity(city);

        // 从 redis 中取数据
        City cityInfo = cityService.findCityById(2L);

        LOGGER.info(cityInfo.toString());
    }

    @Test
    public void testRedisCache() {
        City city = new City();
        city.setCityName("北京");
        city.setDescription("Beijing");
        city.setProvinceId(4L);
        city = cityService.saveCity(city);

        // 从 redis 中取数据, 第一次查询
        City cityInfo = cityService.findCityById(4L);
        LOGGER.info("第一次查询：" + cityInfo.toString());

        // 从 redis 中取数据, 第二次查询
        cityInfo = cityService.findCityById(4L);
        LOGGER.info("第二次查询：" + cityInfo.toString());

        // 更新 city 的描述信息后查询
        city.setDescription("来嘛来嘛");
        cityService.updateCity(city);
        cityInfo = cityService.findCityById(city.getId());
        LOGGER.info("更新描述后查询：" + cityInfo.toString());

    }
}