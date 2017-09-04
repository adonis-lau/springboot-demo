package bid.adonis.lau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/8/29 22:02
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class SpringbootApplication {
    // 程序启动入口
    // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
