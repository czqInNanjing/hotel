package cn.edu.nju.service;

import cn.edu.nju.vo.MemberInfoVO;

import java.util.Map;

/**
 * @author Qiang
 * @since 27/02/2017
 */
public interface MemberService {
    boolean isActivated(int id);

    /**
     * If succeed, add points to the member account
     * @param id        memberid
     * @param amount    pay amount
     * @return          whether success
     */
    boolean pay(int id, int amount);
    boolean recharge(int id, int amount);
    void addPoints(int id, int amount);

    /**
     * convert points to deposit, the default strategy is 1 to 1
     * @param id                userId
     * @param points            points to be converted
     * @return                  message
     */
    Map<String , Object> convertPoints(int id, int points);

    MemberInfoVO getMemberProfile(int id);
}
