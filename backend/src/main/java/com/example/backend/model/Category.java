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
	@JoinColumn(name = "subcategory")
	private List<SubCategory> subCategories = new ArrayList<SubCategory>();
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Product> products = new ArrayList<Product>();

	public Category() {
	}

	public Category(String name, String image) {
		this.name = name;
		this.image = image;
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

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addSubCategory(SubCategory subCategory) {
		this.subCategories.add(subCategory);
	}

}