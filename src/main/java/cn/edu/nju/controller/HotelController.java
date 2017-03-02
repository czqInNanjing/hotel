package cn.edu.nju.controller;

import cn.edu.nju.dao.HotelRepository;
import cn.edu.nju.dao.RoomsRepository;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.RoomsEntity;
import cn.edu.nju.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    private final HotelRepository hotelRepository;
    private final RoomsRepository roomsRepository;
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelRepository hotelRepository, RoomsRepository roomsRepository, HotelService hotelService) {
        this.hotelRepository = hotelRepository;
        this.roomsRepository = roomsRepository;
        this.hotelService = hotelService;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index(HttpSession session, Model model) {

        if (session.getAttribute("id") != null) {
            int id = (int) session.getAttribute("id");
            HotelEntity hotel = hotelRepository.findOne(id);

            if (hotel.getStatus() == 0) {
                model.addAttribute("status", 0);

            } else {
                model.addAttribute("status", 1);
                List<RoomsEntity> roomsEntities = roomsRepository.findByHotelId(id);

                model.addAttribute("rooms", roomsEntities);
            }


        }


        return "hotel/index";
    }

    @RequestMapping("/info")
    public String info(HttpSession session, Model model, @SessionAttribute int id) {

        HotelEntity hotel = hotelRepository.findOne(id);

        model.addAttribute("hotel", hotel);

        if (hotelService.isApplyingForEditing(id)) {
            model.addAttribute("edit" , true);
        }
        if (hotelService.isApplyingForOpen(id)) {
            model.addAttribute("open" , true);
        }

        return "/hotel/info";
}

    @RequestMapping("/statistics")
    public String statistics() {
        return "/hotel/statistics";
    }


    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public String openApplication(HttpSession session,Model model ,String reason, @SessionAttribute int id) {
        hotelService.saveOpenApplication(reason, id);
        return info(session, model ,id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editApplication(HttpSession session,Model model ,String name, String address, String description, @SessionAttribute int id) {

        hotelService.saveModifyApplication(name, address, description, id);

        return info(session, model ,id);
    }

    @RequestMapping(value = "/addRooms", method = RequestMethod.POST)
    @ResponseBody
    public List<RoomsEntity> addNewRooms(String time, boolean wifi, String picUrl, int area, int type, int price, int number, @SessionAttribute int id){

        // TODO REMOVE futile return
        return hotelService.addRooms(time, wifi, picUrl, area, type, price, number, id);
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
