package bid.adonis.lau.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
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
        entityManagerFactoryRef = "entityManagerFactoryMaster",//实体管理引用
        transactionManagerRef = "transactionManagerMaster",//事务管理引用
        basePackages = {"bid.adonis.lau.dao.master"}) //设置使用Master数据源的dao的包名
public class MasterDataSourceConfig {
    //注入Master数据源
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;

    //配置EntityManager实体
    @Primary
    @Bean(name = "entityManagerMaster")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryMaster(builder).getObject().createEntityManager();
    }

    //配置EntityManager工厂实体
    @Primary
    @Bean(name = "entityManagerFactoryMaster")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMaster(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(masterDataSource)
                .properties(getVendorProperties())
                .packages(new String[]{"bid.adonis.lau.entity.master"}) //设置实体类所在包名
                .persistenceUnit("masterPersistenceUnit")
                .build();
    }

    //注入jpa配置实体
    @Autowired
    private JpaProperties jpaProperties;

    //获取jpa配置信息
    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    //配置事务
    @Primary
    @Bean(name = "transactionManagerMaster")
    public PlatformTransactionManager transactionManagerMaster(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMaster(builder).getObject());
    }
}
