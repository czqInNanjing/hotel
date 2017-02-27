package cn.edu.nju.controller;

import cn.edu.nju.dao.HotelRepository;
import cn.edu.nju.dao.OpenApplicationRepository;
import cn.edu.nju.entity.HotelEntity;
import cn.edu.nju.entity.OpenApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    private final HotelRepository hotelRepository;
    private final OpenApplicationRepository openApplicationRepository;

    @Autowired
    public HotelController(HotelRepository hotelRepository, OpenApplicationRepository openApplicationRepository) {
        this.hotelRepository = hotelRepository;
        this.openApplicationRepository = openApplicationRepository;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "hotel/index";
    }


    @RequestMapping("/getOpenApplications")
    public void getOpenApplications(Model model, int id) {

        List<OpenApplicationEntity> entities = openApplicationRepository.findByHotelId(id);
        model.addAttribute("OpenApplications", entities);

    }


    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public void openApplication(int id, String reason) {
        OpenApplicationEntity openApplication = new OpenApplicationEntity();
        openApplication.setHotelId(id);
        openApplication.setReason(reason);

        openApplicationRepository.save(openApplication);


    }


//    @RequestMapping("/register")
//    public String register() {
//        return "redirect:/account/register";
//    }
//
//    @RequestMapping("/logout")
//    public String logout(SessionStatus sessionStatus) {
//        sessionStatus.setComplete();
//        return "redirect:/account/index";
//    }


}
