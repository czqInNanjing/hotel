package cn.edu.nju.controller;

import cn.edu.nju.service.impl.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Qiang
 * @since 27/02/2017
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping({"/", "/index"})
    public String index(@SessionAttribute int id, Model model) {
        model.addAttribute("opens", managerService.getAllOpenApplication());
        model.addAttribute("edits" , managerService.getAllModifyApplication());

        return "/manager/index";
    }


    @RequestMapping(value = "/approve" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> approve(boolean isApprove, boolean openOrModify, @RequestParam("operationArray[]") List<Integer> operationArray){
        return managerService.approve(isApprove, openOrModify, operationArray);
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
