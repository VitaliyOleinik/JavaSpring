package com.group11.db;

public class SecondBean {

    private String theParam;
    private FirstBean firstBean;

    public SecondBean() {
    }

    public String getTheParam() {
        return theParam;
    }

    public void setTheParam(String theParam) {
        this.theParam = theParam;
    }

    public FirstBean getFirstBean() {
        return firstBean;
    }

    public void setFirstBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }

    public SecondBean(String theParam, FirstBean firstBean) {
        this.theParam = theParam;
        this.firstBean = firstBean;
    }

    public String getData(){
        return theParam+" "+firstBean.getSomeParam() + " " + firstBean.getSomeValue();
    }
}
