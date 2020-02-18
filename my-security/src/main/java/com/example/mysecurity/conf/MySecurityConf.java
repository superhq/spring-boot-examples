package com.example.mysecurity.conf;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConf extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/index.html")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
