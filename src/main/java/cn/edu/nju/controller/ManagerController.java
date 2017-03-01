package cn.edu.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {


    @RequestMapping({"/", "/index"})
    public String index() {


        return "/manager/index";
    }

    @RequestMapping("/statistics")
    public String statistics() {
        return "/manager/statistics";
    }

    @RequestMapping("/register")
    public String register() {
        return "redirect:/register";
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/index";
    }
}
