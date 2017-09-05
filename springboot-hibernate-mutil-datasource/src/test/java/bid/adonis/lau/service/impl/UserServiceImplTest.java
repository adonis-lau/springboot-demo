package bid.adonis.lau.service.impl;

import bid.adonis.lau.SpringbootApplication;
import bid.adonis.lau.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/5 14:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void transactionalTest() {
        userService.transactionalTest();
    }
}