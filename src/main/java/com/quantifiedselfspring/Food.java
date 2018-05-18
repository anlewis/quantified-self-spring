package com.quantifiedselfspring;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "food")
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "calories")
    private Integer calories;

    public Food() {
        super();
    }

    public Food(Long id, String name, Integer calories) {
        super();
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

}