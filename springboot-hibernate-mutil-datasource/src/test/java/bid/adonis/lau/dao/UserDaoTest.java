package bid.adonis.lau.dao;

import bid.adonis.lau.SpringbootApplication;
import bid.adonis.lau.dao.cluster.UserDao;
import bid.adonis.lau.entity.cluster.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/5 14:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void findOneByName() throws Exception {
        User user = userDao.findOneByName("adonis");
        System.out.println(user);
    }

}