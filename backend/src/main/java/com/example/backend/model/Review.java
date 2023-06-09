package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@Column(nullable = false)
	private int classification;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer author;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public Review() {

	}

	public Review(int classification, String comment, Customer author, Product product) {
		this.classification = classification;
		this.comment = comment;
		this.author = author;
		this.product = product;
	}

	public int getClassification() {
		return this.classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getAuthor() {
		return author;
	}

	public void setAuthor(Customer author) {
		this.author = author;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}