package com.example.secureapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Guest").password("{noop}qwerty").authorities("read")
                .and()
                .withUser("User").password("{noop}qwertyend").authorities("read","send")
                .and()
                .withUser("Admin").password("{noop}admin").authorities("read","send","delete");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hi").permitAll()
                .and()
                .authorizeRequests().antMatchers("read").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("send").hasAuthority("send")
                .and()
                .authorizeRequests().antMatchers("delete").hasAuthority("delete")
                .and()
                .authorizeRequests().anyRequest().authenticated();

    }
}

