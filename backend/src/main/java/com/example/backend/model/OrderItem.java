package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("orderitem")
public class OrderItem extends Item {
	private double price;

	public OrderItem() {

	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}