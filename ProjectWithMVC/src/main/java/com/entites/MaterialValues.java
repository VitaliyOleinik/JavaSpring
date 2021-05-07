package com.entites;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "material_value")
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MaterialValues {
    // @GeneratedValue - указывает, что данное свойство будет создаваться согласно указанной стратегии.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "cost")
    private int cost;

    @Column(name = "total")
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
