package bid.adonis.lau.controller;

import bid.adonis.lau.entity.master.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * @author: Adonis Lau
 * @date: 2018/8/17 16:27
 */
@RestController
@RequestMapping("/api")
public class CityRestController {

    private final CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByCityName(cityName);
    }

}
