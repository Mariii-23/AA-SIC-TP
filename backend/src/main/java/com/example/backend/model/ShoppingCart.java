package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@OneToMany
	private List<Item> items = new ArrayList<>();

	public ShoppingCart() {

	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}