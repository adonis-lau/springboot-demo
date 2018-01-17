package bid.adonis.lau.dubbo;

import bid.adonis.lau.domain.City;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * @author: adonis lau
 * @email: adonis.lau.dev@gmail.com
 * @date: Created in 2018/1/17 22:54
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    /**
     * 输出查询到的城市
     */
    public void printCity() {
        String cityName = "温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
