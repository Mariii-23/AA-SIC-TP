package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"image", "product_id"}))
public class Image {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;

	@Lob
	@Column(nullable = false, length = 20971520)
	private byte[] image;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public Image() {

	}

	public Image(byte[] image, Product product) {
		this.image = image;
		this.product = product;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}