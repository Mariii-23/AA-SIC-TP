package com.example.backend.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="_order")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;

	@Column(nullable = false)
	private LocalDate date;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private boolean storePickUp;

	@Column(nullable = false)
	private double total;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderItem> items = new ArrayList<OrderItem>();

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private OrderState state;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	public Order() {

	}

	public Order(LocalDate date, String address, boolean storePickUp, double total, List<OrderItem> items, OrderState state, Customer customer) {
		this.date = date;
		this.address = address;
		this.storePickUp = storePickUp;
		this.total = total;
		this.items = items;
		this.state = state;
		this.customer = customer;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getStorePickUp() {
		return this.storePickUp;
	}

	public void setStorePickUp(boolean storePickUp) {
		this.storePickUp = storePickUp;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isStorePickUp() {
		return storePickUp;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}