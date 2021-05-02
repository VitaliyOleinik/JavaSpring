package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // Конфигурационный класс
@EnableWebMvc
@ComponentScan(basePackages = {"com"})  // Основной пакет
public class WebMVCConfig implements WebMvcConfigurer { // имплементирую WebMvcConf
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // устанавливаю префикс и суффикс
        resolver.setPrefix("/WEB-INF/views/"); // нахождение view
        resolver.setSuffix(".jsp"); // тип файлов
        return resolver;
    }

}
