package com.javastart.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.anyRequest().authenticated());
        http.csrf().disable();
/*        http.formLogin(login -> login
                .loginPage("/logowanie")
                .usernameParameter("user")
                .passwordParameter("pass")
                .permitAll());*/
        http.logout(logout -> logout.logoutUrl("/wyloguj"));
        http.logout(logout -> logout
                .logoutSuccessUrl("/byebye")
                .permitAll()
        );
        http.formLogin(login -> login.loginPage("/login").permitAll());
    }

}
