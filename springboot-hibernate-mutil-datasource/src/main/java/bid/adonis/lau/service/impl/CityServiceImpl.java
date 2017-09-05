package bid.adonis.lau.service.impl;

import bid.adonis.lau.dao.master.CityDao;
import bid.adonis.lau.entity.master.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 城市业务逻辑实现类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByCityName(String cityName) {
        return cityDao.findCityByCityName(cityName);
    }

}
