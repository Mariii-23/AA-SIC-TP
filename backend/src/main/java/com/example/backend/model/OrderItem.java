package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("orderitem")
public class OrderItem extends Item {
	@Column(nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	public OrderItem() {

	}

	public OrderItem(Item item){
		super(item);
		this.price = item.getProduct().getPrice();
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}