package com.javaelites.lawyercatalogservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.javaelites.lawyercatalogservice.security.RestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    RestAuthenticationFilter restAuthenticationFilter;
    
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.httpBasic().disable();
    }
	
	@Bean
	public FilterRegistrationBean<RestAuthenticationFilter> filterRegistrationBean() {
	    FilterRegistrationBean < RestAuthenticationFilter > registrationBean = new FilterRegistrationBean();
	    registrationBean.setFilter(restAuthenticationFilter);
	    registrationBean.addUrlPatterns("/api/*");
	    return registrationBean;
	}
}
