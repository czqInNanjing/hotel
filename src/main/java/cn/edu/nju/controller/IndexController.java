package cn.edu.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Qiang
 * @since 26/02/2017
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "account/index";
    }
}
