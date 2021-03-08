package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com"})
public class WebMVCConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver =new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/src/webapp/WEB-INF/views");
        return resolver;
    }
}