package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@DiscriminatorValue("Customer")
public class Customer extends User {

	@Column
	private Date birthday;

	@Column(unique = true)
	private String nif;

	@Column
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	public List<Review> reviews  = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private ShoppingCart cart;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orders;

	@ManyToMany
	@JoinTable(
			name = "customer_favourites",
			joinColumns = @JoinColumn(name = "customer_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> favourites = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(Date birthday, String nif, String address, String email, String password, String name, ShoppingCart cart) {
		super(email, password, name);
		this.birthday = birthday;
		this.nif = nif;
		this.address = address;
		this.cart = cart;
		super.setRole(Role.CUSTOMER);
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

	public List<Product> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<Product> favorites) {
		this.favourites = favorites;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addFavourite(Product product) {
		this.favourites.add(product);
	}

	public void removeFavourite(Product product) {
		this.favourites.remove(product);
	}
}