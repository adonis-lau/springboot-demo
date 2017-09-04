package bid.adonis.lau.controller;

import bid.adonis.lau.entity.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/city/{id}")
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @GetMapping(value = "/city")
    public List<City> findAllCity() {
        return cityService.findAllCity();
    }

    @PostMapping(value = "/city")
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @PutMapping(value = "/city")
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @DeleteMapping(value = "/city/{id}")
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
