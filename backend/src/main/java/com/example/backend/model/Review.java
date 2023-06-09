package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	private int classification;
	private String comment;
	@ManyToOne
	private Customer author;

	public Review() {

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
}