package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;


@Entity
@DiscriminatorValue("Customer")
public class Costumer extends User {
	private Date birthday;
	private String nif;
	private String address;
	@OneToOne
	private ShoppingCart cart;
	@OneToMany
	private ArrayList<Order> orders = new ArrayList<Order>();
	@OneToMany
	private ArrayList<Product> favorites = new ArrayList<Product>();

	public Costumer() {
		super();
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ShoppingCart getCart() {
		return this.cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Product> getFavorites() {
		return favorites;
	}

	public void setFavorites(ArrayList<Product> favorites) {
		this.favorites = favorites;
	}
}