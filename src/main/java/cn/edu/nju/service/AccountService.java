package cn.edu.nju.service;

/**
 * Deal with account verification or account CRUD
 * @author Qiang
 * @since 25/02/2017
 */
public interface AccountService {
    /**
     * Login
     * @param mail          the email
     * @param password      the password
     * @return              0 if a member, 1 if a hotel manager, 2 if a general manager
     */
    int login(String mail, String password);

    /**
     * Register as a member
     * @param mail          the email
     * @param password      the password
     * @return              id if succeeded, -1 if failed
     */
    int register(String mail, String password);



}

