package com.example.firstservice;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

    /**
     * 스프링시큐리티 앞단 설정
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    /**
     * 스프링시큐리티의 설정
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/welcome").permitAll();
    }
}
