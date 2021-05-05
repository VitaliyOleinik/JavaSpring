package com.entites;

public class MaterialValues {
    private Long id;
    private String name;
    private int cost;
    private int total;

    public MaterialValues(Long id, String name, int cost, int total) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.total = total;
    }

    public MaterialValues(Long id, String name, int cost) {
        this(id, name, cost, 0);
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MaterialValues{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", total=" + total +
                '}';
    }
}
