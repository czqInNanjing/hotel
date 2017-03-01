package cn.edu.nju.controller;

import cn.edu.nju.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {
    private final MemberRepository repo;

    @Autowired
    public MemberController(MemberRepository repo) {
        this.repo = repo;
    }

    @RequestMapping({"/", "/index"})
    public String index() {


        return "/member/index";
    }


    @RequestMapping("/profile")
    public String profile(HttpSession session, Model model) {
        if (session.getAttribute("id") != null) {
            model.addAttribute("member", repo.findOne((int) session.getAttribute("id")));
        }
        return "/member/profile";
    }

    @RequestMapping("/statistics")
    public String statistics() {
        return "/member/statistics";
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
