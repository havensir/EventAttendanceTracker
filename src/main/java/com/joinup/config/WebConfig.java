package com.joinup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Custom error pages
        registry.addViewController("/error/403").setViewName("error-403");
        registry.addViewController("/error/404").setViewName("error-404");
    }
}
