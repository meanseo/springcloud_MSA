package com.example.userservice.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.Filter;

/**
 * https://velog.io/@pjh612/Deprecated%EB%90%9C-
 * WebSecurityConfigurerAdapter-%EC%96%B4%EB%96%BB%EA%B2%8C-
 * %EB%8C%80%EC%B2%98%ED%95%98%EC%A7%80
 */

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws
//            Exception{
//        http.csrf().disable();
//                //.authorizeRequests().antMatchers("/user/**").permitAll();
//        http.authorizeRequests().antMatchers("/**")
//                .hasIpAddress("192.168.0.149")
//                .and()
//                .addFilter(getAuthenticationFilter());
//        http.headers().frameOptions().disable();
//
//        return http.build();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**")
                .hasIpAddress("192.168.0.149")
                .and()
                .addFilter(getAuthenticationFilter());
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        authenticationFilter.setAuthenticationManager(authenticationManager());
        return authenticationFilter;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userService).passwordEncoder();
//    }



}
