package cn.edu.nju.controller;

import cn.edu.nju.dao.AccountRepository;
import cn.edu.nju.dao.HotelRepository;
import cn.edu.nju.dao.MemberRepository;
import cn.edu.nju.entity.AccountEntity;
import cn.edu.nju.entity.MemberEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@Controller
@SessionAttributes("id")
public class AccountController {
    private final AccountRepository repository;
    private final MemberRepository memberRepository;
    private final HotelRepository hotelRepository;


    @Autowired
    public AccountController(AccountRepository repository, MemberRepository memberRepository, HotelRepository hotelRepository) {
        this.repository = repository;
        this.memberRepository = memberRepository;

        this.hotelRepository = hotelRepository;
    }

    //TODO Check Login status in each request use Spring Security
    //TODO Check Form

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session,Model model, String mail, String password) {

        AccountEntity result = repository.findByMailAndPassword(mail, password);

        if (result != null) {

            session.setAttribute("id" , result.getId());
            switch (result.getType()) {
                case 0:
                    return "redirect:/member/index";
                case 1:
                    return "redirect:/hotel/index";
                case 2:
                    return "redirect:/manager/index";
                default:
                    return "account/index";
            }
        }

        model.addAttribute("error" , "mail or password error");
        return "account/index";

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, String mail, String password) {

        AccountEntity entity = repository.findByMail(mail);

        if (entity != null) {
            model.addAttribute("error", "Mail Existed");
            return "account/register";
        } else {
            entity = new AccountEntity(mail, password);

            repository.save(entity);
            entity = repository.findByMail(mail);
            MemberEntity memberEntity = new MemberEntity();

            BeanUtils.copyProperties(entity, memberEntity);
            memberRepository.save(memberEntity);

            return "account/index";
        }


    }

    @RequestMapping({"/","/login"})
    public String login() {
        return "account/index";
    }

    @RequestMapping("/register")
    public String register() {
        return "account/register";
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "account/index";
    }






}
