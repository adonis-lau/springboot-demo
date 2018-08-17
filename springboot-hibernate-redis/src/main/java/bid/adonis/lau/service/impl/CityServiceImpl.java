package bid.adonis.lau.service.impl;

import bid.adonis.lau.dao.CityDao;
import bid.adonis.lau.entity.City;
import bid.adonis.lau.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<City> findAllCity() {
        return cityDao.findAll();
    }

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    public City findCityById(Long id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();

        // 缓存存在
        if (redisTemplate.hasKey(key)) {
            City city = operations.get(key);

            logger.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityDao.findById(id).orElse(null);

        // 插入缓存
        operations.set(key, city, 10L, TimeUnit.SECONDS);
        logger.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + (city != null ? city.toString() : null));

        return city;
    }

    @Override
    public City saveCity(City city) {
        return cityDao.save(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public City updateCity(City city) {
        city = cityDao.save(city);

        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
            logger.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }

        return city;
    }

    @Override
    public void deleteCity(Long id) {
        cityDao.deleteById(id);

        //如果缓存存在，删除缓存
        String key = "city_" + id;
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
            logger.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }

    }

}
