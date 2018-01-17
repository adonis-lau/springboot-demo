package bid.adonis.lau.dubbo.impl;

import bid.adonis.lau.domain.City;
import bid.adonis.lau.dubbo.CityDubboService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 城市业务 Dubbo 服务层实现层
 * 注册为 Dubbo 服务
 *
 * @author: adonis lau
 * @email: adonis.lau.dev@gmail.com
 * @date: Created in 2018/1/17 22:21
 */
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名称
     * @return city
     */
    @Override
    public City findCityByName(String cityName) {
        return new City(1L, 2L, "温岭", "是我的故乡");
    }
}
