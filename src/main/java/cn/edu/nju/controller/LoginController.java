package cn.edu.nju.controller;

import cn.edu.nju.dao.AccountRepository;
import cn.edu.nju.entity.AccountEntity;
import org.aspectj.apache.bcel.classfile.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@Controller
public class LoginController {
    private final AccountRepository repository;

    @Autowired
    public LoginController(AccountRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String mail, String password) {

        AccountEntity result = repository.findByMailAndPassword(mail, password);

        if (result != null) {
            switch (result.getType()) {
                case 0:
                    return "member";
                case 1:
                    return "hotel";
                case 2:
                    return "manager";
                default:
                    return "index";
            }
        }

        model.addAttribute("error" , "mail or password error");
        return "index";

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, String mail, String password) {

        AccountEntity entity = repository.findByMail(mail);

        if (entity != null) {
            model.addAttribute("error", "Mail Existed");
            return "register";
        } else {
            entity = new AccountEntity(mail, password);

            repository.save(entity);

            return "index";
        }


    }

}
