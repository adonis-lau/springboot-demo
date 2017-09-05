package bid.adonis.lau.service;


import bid.adonis.lau.entity.master.City;

/**
 * 城市业务逻辑接口类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName
     * @return City
     */
    City findCityByCityName(String cityName);
}
