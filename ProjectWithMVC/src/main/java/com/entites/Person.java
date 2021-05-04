package com.entites;

public class Person {
    private Long id;
    private String fullName;
    private int cnt;
    private int totalCost;

    public Person(Long id, String fullName, int cnt, int totalCost) {
        this.id = id;
        this.fullName = fullName;
        this.cnt = cnt;
        this.totalCost = totalCost;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", cnt=" + cnt +
                ", totalCost=" + totalCost +
                '}';
    }
}
