package com.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TestBean {

    public TestBean(){
        System.out.println("Initializing TEST BEAN");
    }

    public String getData(){
        return "Hello!";
    }
}
