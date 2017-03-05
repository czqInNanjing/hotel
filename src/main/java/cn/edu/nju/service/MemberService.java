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
    Map<String, Object> recharge(int id, int amount);
    void addPoints(int id, int amount);

    /**
     * convert points to deposit, the default strategy is 1 to 1
     * @param id                userId
     * @param points            points to be converted
     * @return                  message
     */
    Map<String , Object> convertPoints(int id, int points);

    MemberInfoVO getMemberProfile(int id);

    /**
     * reserve a room for specific user
     * @param id
     * @param roomId
     * @return
     */
    Map<String,Object> reserve(int id, int roomId);

    Map<String,Object> edit(int id, String name, String mail, String creditCard);

    Map<String,Object> deleteAccount(int id, String password);
    void deleteAccount(int id);
}
