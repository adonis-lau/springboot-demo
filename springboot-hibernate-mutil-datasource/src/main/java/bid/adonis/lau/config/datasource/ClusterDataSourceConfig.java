package bid.adonis.lau.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/5 11:39
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryCluster",//实体管理引用
        transactionManagerRef = "transactionManagerCluster",//事务管理引用
        basePackages = {"bid.adonis.lau.dao.cluster"}) //设置使用Cluster数据源的dao的包名
public class ClusterDataSourceConfig {
    //注入Cluster数据源
    @Autowired
    @Qualifier("clusterDataSource")
    private DataSource clusterDataSource;

    //配置EntityManager实体
    @Bean(name = "entityManagerCluster")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryCluster(builder).getObject().createEntityManager();
    }

    //配置EntityManager工厂实体
    @Bean(name = "entityManagerFactoryCluster")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryCluster(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(clusterDataSource)
                .properties(getVendorProperties(clusterDataSource))
                .packages(new String[]{"bid.adonis.lau.entity.cluster"}) //设置实体类所在包名
                .persistenceUnit("clusterPersistenceUnit")
                .build();
    }

    //注入jpa配置实体
    @Autowired
    private JpaProperties jpaProperties;

    //获取jpa配置信息
    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    //配置事务
    @Bean(name = "transactionManagerCluster")
    public PlatformTransactionManager transactionManagerCluster(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryCluster(builder).getObject());
    }
}
