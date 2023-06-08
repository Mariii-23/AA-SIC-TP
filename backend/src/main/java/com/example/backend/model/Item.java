package com.example.backend.model;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "itemtype",
		discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("item")
public class Item {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	private int quantity;
	@ManyToOne
	private Material material;
	@ManyToOne
	private Product product;

	public Item() {

	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}