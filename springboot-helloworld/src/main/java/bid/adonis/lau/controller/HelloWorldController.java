package bid.adonis.lau.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/8/31 23:24
 */
// @RestController 所有函数不解析返回的字符串
@RestController
@RequestMapping("/first")
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World !";
    }
}
