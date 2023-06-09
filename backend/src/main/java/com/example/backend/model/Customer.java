package com.example.backend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@DiscriminatorValue("Customer")
public class Customer extends User {
	private Date birthday;
	private String nif;
	private String address;
	@OneToMany
	public List<Review> reviews;
	@OneToOne
	private ShoppingCart cart;
	@OneToMany
	private List<Order> orders;
	@OneToMany
	private List<Product> favorites;

	public Customer() {
		super();
	}

	public Customer(Date birthday, String nif, String address, String email, String password, String name) {
		super(email, password, name);
		this.birthday = birthday;
		this.nif = nif;
		this.address = address;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Product> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Product> favorites) {
		this.favorites = favorites;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}