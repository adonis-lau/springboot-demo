package bid.adonis.lau.service.impl;

import bid.adonis.lau.dao.CityDao;
import bid.adonis.lau.entity.City;
import bid.adonis.lau.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CityDao cityDao;

    private final RedisTemplate redisTemplate;

    @Autowired
    public CityServiceImpl(CityDao cityDao, RedisTemplate redisTemplate) {
        this.cityDao = cityDao;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<City> findAllCity() {
        return cityDao.findAll();
    }

    @Cacheable(value = "baseCityInfo")
    @Override
    public City findCityById(Long id) {
        return cityDao.findById(id).orElse(null);
    }

    @CachePut(value = "baseCityInfo")
    @Override
    public City saveCity(City city) {
        return cityDao.save(city);
    }

    @Override
    public City updateCity(City city) {
        return cityDao.save(city);
    }

    @CacheEvict(value = "baseCityInfo")
    @Override
    public void deleteCity(Long id) {
        cityDao.deleteById(id);
    }

}
