package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@OneToMany
	private ArrayList<Item> items = new ArrayList<Item>();

	public ShoppingCart() {

	}
}