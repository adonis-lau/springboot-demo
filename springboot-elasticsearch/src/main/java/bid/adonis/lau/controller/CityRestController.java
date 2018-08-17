package bid.adonis.lau.controller;

import bid.adonis.lau.domain.City;
import bid.adonis.lau.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * @author: adonis lau
 * @email: adonis.lau.dev@gmail.com
 * @date: Created in 2018/1/22 22:18
 */
@RestController
@RequestMapping(value = "/api/city")
public class CityRestController {

    private final CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<City> searchCity(@RequestParam(value = "pageNumber") Integer pageNumber,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "searchContent") String searchContent) {
        return cityService.searchCity(pageNumber, pageSize, searchContent);
    }
}
