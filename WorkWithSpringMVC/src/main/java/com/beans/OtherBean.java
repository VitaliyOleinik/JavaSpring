package com.beans;

public class OtherBean {
    private String textData;
    public OtherBean(){
        this.textData = "Hello From Other Bean!";
    }
    public OtherBean(String textData){
        this.textData = textData;
    }
    public String getData(){
        return this.textData;
    }
}
