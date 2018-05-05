package pro.khairutdinov.model;


import javax.inject.Inject;
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int cost;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String name, int cost, Category category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
