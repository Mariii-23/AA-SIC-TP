package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private String name;

	private String description;

	@ManyToMany
	private List<Material> materials = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<TechnicalInfo> infos = new ArrayList<TechnicalInfo>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Review> reviews = new ArrayList<Review>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Image> images = new ArrayList<Image>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	public Product() {
	}

	public Product(double price, String name, String description, List<Material> materials, Category category) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.materials = materials;
		this.category = category;
	}

	public Product(double price, String name, String description, List<Material> materials, Category category, SubCategory subCategory) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.materials = materials;
		this.category = category;
		this.subCategory = subCategory;
	}

	public int getiD() {
		return iD;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public List<TechnicalInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<TechnicalInfo> infos) {
		this.infos = infos;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
}