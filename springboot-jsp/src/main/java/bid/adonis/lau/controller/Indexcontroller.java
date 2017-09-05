package bid.adonis.lau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/5 16:16
 */
@Controller
@RequestMapping("index")
public class Indexcontroller {

    @GetMapping("")
    public String index() {
        return "index";
    }
}
