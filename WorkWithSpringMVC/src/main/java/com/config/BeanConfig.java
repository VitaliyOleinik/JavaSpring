package com.config;

import com.beans.OtherBean;
import com.db.DBManagerPhpMyAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com"})
public class BeanConfig {

    @Bean
    @Scope("singleton")
    public OtherBean myOtherBean(){
        return new OtherBean("Hello From Nice Site");
    }

    @Bean
    @Scope("singleton")
    public OtherBean mySecondBean(){
        return new OtherBean();
    }

    @Bean
    @Scope("singleton")
    public DBManagerPhpMyAdmin dbManagerPhpMyAdmin(){
        return new DBManagerPhpMyAdmin();
    }
}
