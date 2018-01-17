package bid.adonis.lau.dao.master;


import bid.adonis.lau.entity.master.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 城市 DAO 接口类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
@Repository
public interface CityDao extends JpaRepository<City, Long> {

    /**
     * 根据城市名称，查询城市信息
     * Hibernate查询，不需要实现，但是函数名必须按照规范来写
     *
     * @param cityName
     * @return City
     */
    City findCityByCityName(String cityName);
}
