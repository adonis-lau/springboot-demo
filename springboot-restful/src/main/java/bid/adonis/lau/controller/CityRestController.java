package bid.adonis.lau.controller;

import bid.adonis.lau.entity.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * @author: Adonis Lau
 * @date: 2018/8/17 16:32
 */
@RestController
@RequestMapping("/api")
public class CityRestController {

    private final CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/{id}")
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping("/city")
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @PostMapping("/city")
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @PutMapping("/city")
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @DeleteMapping("/city/{id}")
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
