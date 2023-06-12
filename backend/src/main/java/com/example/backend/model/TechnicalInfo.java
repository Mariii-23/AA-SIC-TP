package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "product_id"}))
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

	public TechnicalInfo(String name, String description, Product product) {
		this.name = name;
		this.description = description;
		this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}