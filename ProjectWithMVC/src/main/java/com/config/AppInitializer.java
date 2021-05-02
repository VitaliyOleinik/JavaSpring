package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Указываю конфигурационные классы
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebMVCConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
    // указываю на пусткую строку
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
