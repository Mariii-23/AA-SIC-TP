package com.example.backend.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;

	@Column(unique = true, nullable = false)
	private String name;

	private String image;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private List<Category> subCategories = new ArrayList<Category>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Product> products = new ArrayList<Product>();

	public Category() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}