package bid.adonis.lau.dao;

import bid.adonis.lau.SpringbootApplication;
import bid.adonis.lau.dao.master.CityDao;
import bid.adonis.lau.entity.master.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/5 9:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class CityDaoTest {

    @Autowired
    CityDao cityDao;

    @Test
    public void findCityByCityName() throws Exception {
        City city = cityDao.findCityByCityName("安阳");
        System.out.println(city);
    }

}