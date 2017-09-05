package bid.adonis.lau.controller;

import bid.adonis.lau.entity.master.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping("/api")
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByCityName(cityName);
    }

}
