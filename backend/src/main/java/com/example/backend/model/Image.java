package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"path", "product_id"}))
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
	public Image(String path, Product product) {
		this.path = path;
		this.product = product;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}