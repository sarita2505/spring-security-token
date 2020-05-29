package com.spring.filter.filter_registration;

import com.spring.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class RegisterFilter {
    @Qualifier("myAuthenticationFilter")
    @Autowired
    private AuthenticationFilter  authenticationFilter;

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> registerAuthenticationFilter(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(authenticationFilter);
        registrationBean.addUrlPatterns("/authenticate");
        return registrationBean;
    }
}
