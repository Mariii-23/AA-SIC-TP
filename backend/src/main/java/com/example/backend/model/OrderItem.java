package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("orderitem")
public class OrderItem extends Item {
	private double price;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {

	}

	public OrderItem(Item item, Order order) {
		super(item);
		this.price = item.getProduct().getPrice() * item.getQuantity();
		this.order = order;
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