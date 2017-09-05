package bid.adonis.lau.service.impl;

import bid.adonis.lau.dao.CityDao;
import bid.adonis.lau.entity.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<City> findAllCity() {
        return cityDao.findAll();
    }

    public City findCityById(Long id) {
        return cityDao.findOne(id);
    }

    @Override
    public City saveCity(City city) {
        return cityDao.save(city);
    }

    @Override
    public City updateCity(City city) {
        return cityDao.save(city);
    }

    @Override
    public void deleteCity(Long id) {
        cityDao.delete(id);
    }

}
