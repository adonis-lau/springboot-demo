package bid.adonis.lau.controller;

import bid.adonis.lau.property.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 15:05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserProperties userProperties;

    @GetMapping("/properties")
    public String properties(){
        return userProperties.toString();
    }
}
