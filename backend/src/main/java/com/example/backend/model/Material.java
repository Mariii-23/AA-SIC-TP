package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Material {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@Column(nullable = false, unique = true)
	private String name;

	@Lob
	private byte[] image;

	@ManyToMany(mappedBy = "materials")
	private List<Product> products = new ArrayList<>();

	public Material() {}

	public Material(String name, byte[] image) {
		this.name = name;
		this.image = image;
	}

	public int getID() {
		return this.iD;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getiD() {
		return iD;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}