package bid.adonis.lau.dao;


import bid.adonis.lau.entity.City;
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

}
