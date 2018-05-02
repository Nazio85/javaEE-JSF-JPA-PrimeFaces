package pro.khairutdinov.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    public Category() {
    }


    public Category(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}
