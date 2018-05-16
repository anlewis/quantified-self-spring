package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "food")
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private String calories;

    protected Food() {

    }

    public Food(String name, String calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return String.format("Food[id=%d, name='%s', calories='%s']", id, name, calories);
    }
}