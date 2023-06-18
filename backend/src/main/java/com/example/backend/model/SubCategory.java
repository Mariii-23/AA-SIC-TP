package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id", "category_id"}))
public class SubCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int iD;
    private String name;
    @Lob
    @Column(length = 20971520)
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @OneToMany(mappedBy = "subCategory", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Product> products = new ArrayList<>();

    public SubCategory() {
    }

    public SubCategory(String name, byte[] image, Category category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }

    public int getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
