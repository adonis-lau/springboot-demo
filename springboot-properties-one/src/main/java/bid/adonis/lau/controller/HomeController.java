package bid.adonis.lau.controller;

import bid.adonis.lau.property.HomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 14:59
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeProperties homeProperties;

    @GetMapping("/properties")
    public String properties(){
        return homeProperties.toString();
    }
}
