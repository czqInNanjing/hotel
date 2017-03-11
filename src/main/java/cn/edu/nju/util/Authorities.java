package cn.edu.nju.util;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Qiang
 * @since 10/03/2017
 */
public class Authorities implements GrantedAuthority {

    private String name;

    public Authorities(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
