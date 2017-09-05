package bid.adonis.lau.service;


import bid.adonis.lau.entity.cluster.User;

/**
 * User业务逻辑接口类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
public interface UserService {

    /**
     * 根据User名称，查询User信息
     *
     * @param name
     * @return User
     */
    User findOneByName(String name);

    /**
     * 保存User
     *
     * @param user
     */
    User saveUser(User user);

    void transactionalTest() throws RuntimeException;
}
