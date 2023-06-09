package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class TechnicalInfo {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@Column(nullable = false)
	private String name;
	private String description;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public TechnicalInfo(){

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
}