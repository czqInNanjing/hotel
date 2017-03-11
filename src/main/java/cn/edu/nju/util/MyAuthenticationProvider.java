package cn.edu.nju.util;


import cn.edu.nju.dao.AccountRepository;
import cn.edu.nju.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiang
 * @since 10/03/2017
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    private final
    AccountRepository accountRepository;

    @Autowired
    public MyAuthenticationProvider(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String mail = authentication.getName();
        String password = (String) authentication.getCredentials();

        AccountEntity result = accountRepository.findByMailAndPassword(mail, password);

        if (result == null) {
            throw new BadCredentialsException("Mail or Password Error");
        }

        String type;

        switch (result.getType()) {
            case 0:type="ROLE_USER";break;
            case 1:type="ROLE_HOTEL";break;
            default:type="ROLE_MANAGER";

        }
        GrantedAuthority grantedAuthority = new Authorities(type);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(1);
        grantedAuthorities.add(grantedAuthority);
        return new UsernamePasswordAuthenticationToken(mail,password,grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
