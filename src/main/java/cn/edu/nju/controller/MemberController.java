package cn.edu.nju.controller;

import cn.edu.nju.dao.MemberRepository;
import cn.edu.nju.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping({"/", "/index"})
    public String index() {


        return "/member/index";
    }


    @RequestMapping("/profile")
    public String profile(@SessionAttribute int id, Model model) {

        model.addAttribute("member", memberService.getMemberProfile(id));

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
