package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	private double price;
	private String name;
	private String description;
	@ManyToMany
	private List<Material> materials = new ArrayList<>();
	@OneToMany
	private List<TechnicalInfo> infos = new ArrayList<TechnicalInfo>();
	@OneToMany
	private List<Review> reviews = new ArrayList<Review>();
	@OneToMany
	private List<Image> images = new ArrayList<Image>();

	public Product() {

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
}