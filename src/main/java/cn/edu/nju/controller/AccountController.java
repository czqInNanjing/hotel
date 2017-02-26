package cn.edu.nju.controller;

import cn.edu.nju.dao.AccountRepository;
import cn.edu.nju.dao.MemberRepository;
import cn.edu.nju.entity.AccountEntity;
import cn.edu.nju.entity.MemberEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author Qiang
 * @since 25/02/2017
 */
@Controller
@SessionAttributes({"mail","name"})
@RequestMapping(value = "/account")
public class AccountController {
    private final AccountRepository repository;
    private final MemberRepository memberRepository;

    @Autowired
    public AccountController(AccountRepository repository, MemberRepository memberRepository) {
        this.repository = repository;
        this.memberRepository = memberRepository;
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String mail, String password) {

        AccountEntity result = repository.findByMailAndPassword(mail, password);

        if (result != null) {


            switch (result.getType()) {
                case 0:
                    model.addAttribute("member", memberRepository.findOne(result.getId()));
                    return "member/index";
                case 1:
                    return "hotel/index";
                case 2:
                    return "manager/index";
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

    @RequestMapping("/login")
    public String login() {
        return "account/login";
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
