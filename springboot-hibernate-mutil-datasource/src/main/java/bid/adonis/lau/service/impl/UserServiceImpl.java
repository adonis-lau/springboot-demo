package bid.adonis.lau.service.impl;

import bid.adonis.lau.dao.cluster.UserDao;
import bid.adonis.lau.entity.cluster.User;
import bid.adonis.lau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User业务逻辑实现类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findOneByName(String name) {
        return userDao.findOneByName(name);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void transactionalTest() throws RuntimeException {
        for (int i = 0; i < 2; i++) {
            User user = new User("" + i, i);
            userDao.save(user);
        }
        throw new RuntimeException("测试");
    }


}
