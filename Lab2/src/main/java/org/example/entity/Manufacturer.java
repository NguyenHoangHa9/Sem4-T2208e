package org.example.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ManufacturerId;

    private String name;
    private String origin;
    private String description;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    public Long getManufacturerId() {
        return ManufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        ManufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
