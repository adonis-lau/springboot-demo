package bid.adonis.lau.controller;

import bid.adonis.lau.entity.cluster.User;
import bid.adonis.lau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public User findOneCity(@RequestParam(value = "name", required = true) String name) {
        return userService.findOneByName(name);
    }

    @GetMapping("/save")
    public void saveTest() {
        userService.transactionalTest();
    }

}
