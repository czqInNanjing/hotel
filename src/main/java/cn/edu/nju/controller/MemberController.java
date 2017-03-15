package cn.edu.nju.controller;

import cn.edu.nju.entity.MemberEntity;
import cn.edu.nju.service.HotelService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.SystemDefault;
import cn.edu.nju.vo.HotelDetailVO;
import cn.edu.nju.vo.MemberInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Locale;
import java.util.Map;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;
    private final HotelService hotelService;
    private  static Locale locale = new Locale("zh");
    @Autowired
    public MemberController(MemberService memberService, HotelService hotelService) {
        this.memberService = memberService;
        this.hotelService = hotelService;
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model,@RequestParam(value = "page", defaultValue = "0") int page) {
        model.addAttribute(SystemDefault.HOTELS, hotelService.getHotelsByPage(page));

        model.addAttribute(SystemDefault.CURRENT_PAGE, page);
        return "member/index";
    }


    @RequestMapping("/profile")
    public String profile(@SessionAttribute(SystemDefault.USER_ID) int id, Model model) {

        model.addAttribute("member", memberService.getMemberProfile(id));

        return "member/profile";
    }

    @PostMapping("/reserve")
    @ResponseBody
    public Map<String, Object> reserve(@SessionAttribute(SystemDefault.USER_ID) int id, int roomId) {
        return memberService.reserve(id, roomId);

    }

    @RequestMapping("/statistics")
    public String statistics(Model model, @SessionAttribute(SystemDefault.USER_ID) int id) {
        model.addAttribute("locale"  ,locale);
        return memberService.statistics(model, id);
    }


    @RequestMapping("/detail")
    public String detail(Model model, int hotelId,@RequestParam(value = "page", defaultValue = "0") int page) {
        HotelDetailVO hotelDetailVO = hotelService.getHotelDetailVOByHotelId(hotelId,page);
        if (hotelDetailVO != null) {
        model.addAttribute(SystemDefault.HOTEL_DETAIL, hotelDetailVO);
    }
        model.addAttribute(SystemDefault.HOTEL_ID, hotelId);
        model.addAttribute(SystemDefault.CURRENT_PAGE, page);
        return "member/detail";
}

    @PostMapping("/edit")
    @ResponseBody
    public Map<String, Object> edit(@SessionAttribute(SystemDefault.USER_ID) int id, String name, String mail, String creditCard){
        return memberService.edit(id, name, mail, creditCard);
    }

    @PostMapping("/recharge")
    @ResponseBody
    public Map<String, Object> recharge(@SessionAttribute(SystemDefault.USER_ID) int id, int amount){
        return memberService.recharge(id, amount);
    }

    @PostMapping("/convert")
    @ResponseBody
    public Map<String, Object> convert(@SessionAttribute(SystemDefault.USER_ID) int id, int amount){
        return memberService.convertPoints(id, amount);
    }

    @PostMapping("/cancelReservation")
    @ResponseBody
    public Map<String, Object> cancelReservation(@SessionAttribute(SystemDefault.USER_ID) int id, int recordToCancel){
        return memberService.cancelReservation(id, recordToCancel);
    }

    @GetMapping("/getDiscount")
    @ResponseBody
    public int getDiscount(int memberId ){
        MemberInfoVO entity  = memberService.getMemberProfile(memberId);
        if (entity != null) {
            return entity.getDiscount();
        } else {
            return -1;
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> convert(@SessionAttribute(SystemDefault.USER_ID) int id, String password){
        Map<String, Object> result = memberService.deleteAccount(id, password);
        if ( (Boolean) result.get(SystemDefault.HTTP_RESULT)) {
            register();
            return null;
        }
        return result;
    }

    @RequestMapping("../register")
    public String register() {
        return "redirect:/register";
    }

}
