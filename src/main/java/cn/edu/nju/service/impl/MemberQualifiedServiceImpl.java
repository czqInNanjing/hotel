package cn.edu.nju.service.impl;

import cn.edu.nju.dao.MemberRepository;
import cn.edu.nju.service.MemberQualifiedService;
import cn.edu.nju.service.MemberService;
import cn.edu.nju.util.SystemDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qiang
 * @since 05/03/2017
 */
@Service
public class MemberQualifiedServiceImpl implements MemberQualifiedService {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    @Autowired
    public MemberQualifiedServiceImpl(MemberRepository MemberRepository, MemberService memberService) {
        this.memberRepository = MemberRepository;
        this.memberService = memberService;
    }

    @Scheduled(cron = "0 0 * * * *")
    @Override
    public void memberQualifiedExecutor() {
        subtractAllRemainDays();
        System.out.println("Again cutting down the remain days");
    }



    @Override
    public void subtractAllRemainDays() {
        memberRepository.findAll().forEach(
                memberEntity -> {
                    memberEntity.setRemainDays(memberEntity.getRemainDays() - 1);
                    // first time expire
                    if (memberEntity.getRemainDays() <= 0 && memberEntity.getStatus() == 0) {
                        if (memberEntity.getDeposit() >= SystemDefault.ACTIVATED_AMOUNT){
                            memberEntity.setRemainDays(365);
                        } else {
                            // stop the account
                            memberEntity.setStatus(0);
                        }
                    } else if (memberEntity.getRemainDays() <= -365) {
                        memberService.deleteAccount(memberEntity.getId());
                    }
                }
        );
    }
}
