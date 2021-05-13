package com.group11.db;

public class FirstBean {

    private String someParam;
    private int someValue;

    public FirstBean() {
    }

    public FirstBean(String someParam, int someValue) {
        this.someParam = someParam;
        this.someValue = someValue;
    }

    public String getSomeParam() {
        return someParam;
    }

    public void setSomeParam(String someParam) {
        this.someParam = someParam;
    }

    public int getSomeValue() {
        return someValue;
    }

    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }
}
