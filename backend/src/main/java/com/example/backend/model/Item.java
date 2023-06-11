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
	@Column(nullable = false)
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "material_id",nullable = false)
	private Material material;
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private ShoppingCart shoppingCart;

	public Item() {}

	public Item(int quantity, Material material, Product product, ShoppingCart shoppingCart) {
		this.quantity = quantity;
		this.material = material;
		this.product = product;
		this.shoppingCart = shoppingCart;
	}

	public Item(Item item){
		this.quantity = item.getQuantity();
		this.material = item.getMaterial();
		this.product = item.getProduct();
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

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public double getPrice() {
		return this.quantity * this.product.getPrice();
	}
}