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
 *
 * @author: Adonis Lau
 * @date: 2018/8/17 16:27
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public User findOneCity(@RequestParam(value = "name", required = true) String name) {
        return userService.findOneByName(name);
    }

    @GetMapping("/save")
    public void saveTest() {
        userService.transactionalTest();
    }

}
