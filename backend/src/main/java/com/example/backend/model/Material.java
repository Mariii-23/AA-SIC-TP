package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Material {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@Column(nullable = false, unique = true)
	private String name;
	private String image;

	public Material() {}

	public Material(String name, String image) {
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


}