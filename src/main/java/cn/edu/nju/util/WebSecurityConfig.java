package cn.edu.nju.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

/**
 * @author Qiang
 * @since 10/03/2017
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;
    private final MyAuthenticationProvider provider;
    private final
    AuthenticationSuccessHandler handler;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler handler, DataSource dataSource, MyAuthenticationProvider provider) {
        this.handler = handler;
        this.dataSource = dataSource;
        this.provider = provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/register", "/cors/*", "/css/*", "/fonts/*", "/img/*", "/js/*").permitAll()
                .antMatchers("/member/*").hasRole("USER")
                .antMatchers("/hotel/*").hasRole("HOTEL")
                .antMatchers("/manager/*").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/").loginProcessingUrl("/login").successHandler(handler)
                .permitAll()
                .and()
                .logout()
                .permitAll().and().exceptionHandling().accessDeniedPage("/" +
                "");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);

    }
}