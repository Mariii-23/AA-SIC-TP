package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	private double price;
	private String name;
	private String description;
	@ManyToMany
	private ArrayList<Material> materials = new ArrayList<Material>();
	@OneToMany
	private ArrayList<TechnicalInfo> infos = new ArrayList<TechnicalInfo>();
	@OneToMany
	private ArrayList<Review> reviews = new ArrayList<Review>();
	@OneToMany
	private ArrayList<Image> images = new ArrayList<Image>();

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

	public ArrayList<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(ArrayList<Material> materials) {
		this.materials = materials;
	}

	public ArrayList<TechnicalInfo> getInfos() {
		return infos;
	}

	public void setInfos(ArrayList<TechnicalInfo> infos) {
		this.infos = infos;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}
}