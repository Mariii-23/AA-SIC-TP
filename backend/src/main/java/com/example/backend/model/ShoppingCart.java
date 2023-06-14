package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "shoppingCart")
	private List<Item> items = new ArrayList<>();

	@OneToOne(mappedBy = "cart")
	private Customer customer;

	public ShoppingCart() {

	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (Item item : items) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

    public void addItem(Item item) {
		items.add(item);
    }
}