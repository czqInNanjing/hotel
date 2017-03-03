package cn.edu.nju.controller;

import cn.edu.nju.service.HotelService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.SystemDefault;
import cn.edu.nju.vo.HotelDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;
    private final HotelService hotelService;
    @Autowired
    public MemberController(MemberService memberService, HotelService hotelService) {
        this.memberService = memberService;
        this.hotelService = hotelService;
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute(SystemDefault.HOTELS, hotelService.getAllHotels());
        return "/member/index";
    }


    @RequestMapping("/profile")
    public String profile(@SessionAttribute(SystemDefault.USER_ID) int id, Model model) {

        model.addAttribute("member", memberService.getMemberProfile(id));

        return "/member/profile";
    }



    @RequestMapping("/statistics")
    public String statistics() {
        return "/member/statistics";
    }


    @RequestMapping("/detail")
    public String detail(Model model, @SessionAttribute(SystemDefault.USER_ID) int id, int hotelId) {
        HotelDetailVO hotelDetailVO = hotelService.getHotelDetailVOByHotelId(hotelId);
        if (hotelDetailVO != null) {
            model.addAttribute(SystemDefault.HOTEL_DETAIL, hotelDetailVO);
        }

        return "/member/detail";
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
