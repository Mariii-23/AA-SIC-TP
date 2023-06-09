package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;

	@Column(nullable = false)
	private String path;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public Image() {

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}