package bid.adonis.lau.dubbo;

import bid.adonis.lau.domain.City;

/**
 * 市业务 Dubbo 服务层
 *
 * @author: adonis lau
 * @email: adonis.lau.dev@gmail.com
 * @date: Created in 2018/1/17 22:53
 */
public interface CityDubboService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名称
     * @return city
     */
    City findCityByName(String cityName);
}
