package bid.adonis.lau.dao.cluster;


import bid.adonis.lau.entity.cluster.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User DAO 接口类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * 根据User名称，查询User信息
     *
     * @param name
     * @return User
     */
    //Hibernate查询，不需要实现，但是函数名必须按照规范来写
    User findOneByName(String name);
}
