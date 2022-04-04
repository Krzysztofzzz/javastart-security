package com.javastart.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.anyRequest().authenticated());
        http.csrf().disable();
        http.formLogin(login -> login.loginPage("/login").permitAll());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsManager userDetailsService = auth.inMemoryAuthentication().getUserDetailsService();
        User.UserBuilder userBuilder = User.builder();
        UserDetails admin = userBuilder.username("superadmin").password("{noop}hard").roles("ADMIN").build();
        UserDetails user1 = userBuilder.username("john").password("{noop}asdf1234").roles("USER").build();
        userDetailsService.createUser(admin);
        userDetailsService.createUser(user1);
    }
}
