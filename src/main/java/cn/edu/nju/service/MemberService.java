package cn.edu.nju.service;

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


}
