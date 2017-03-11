package cn.edu.nju.util;

import cn.edu.nju.controller.AccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Qiang
 * @since 10/03/2017
 */
@Component
public class MySpringSecurityHandler
        implements AuthenticationSuccessHandler {

//    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private AccountController accountController;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException {
       String url =  accountController.login(request.getSession(), authentication.getName(), (String) authentication.getCredentials());
        redirectStrategy.sendRedirect(request, response, url);
//        handle(request, response, authentication);
//        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication)
            throws IOException {


        accountController.login(request.getSession(), authentication.getName(), (String) authentication.getCredentials());
//        String targetUrl = determineTargetUrl(authentication);
//
//        if (response.isCommitted()) {
////            logger.debug(
////                    "Response has already been committed. Unable to redirect to "
////                            + targetUrl);
//            return;
//        }
//
//        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

//    protected String determineTargetUrl(Authentication authentication) {
//        boolean isUser = false;
//        boolean isAdmin = false;
//        boolean isManager = false;
//        Collection<? extends GrantedAuthority> authorities
//                = authentication.getAuthorities();
//        for (GrantedAuthority grantedAuthority : authorities) {
//            if (grantedAuthority.getAuthority().equals("USER")) {
//                isUser = true;
//                break;
//            } else if (grantedAuthority.getAuthority().equals("HOTEL")) {
//                isAdmin = true;
//                break;
//            } else if (grantedAuthority.getAuthority().equals("MANAGER")) {
//                isManager = true;
//            }
//        }
//
//        if (isUser) {
//            return "/homepage.html";
//        } else if (isAdmin) {
//            return "/console.html";
//        } else if (isManager ) {
//return "/"
//        }else
//            {
//                throw new IllegalStateException();
//            }
//
//    }
//
//    protected void clearAuthenticationAttributes(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return;
//        }
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//    }
//
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
//    protected RedirectStrategy getRedirectStrategy() {
//        return redirectStrategy;
//    }
}