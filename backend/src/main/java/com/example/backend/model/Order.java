package com.example.backend.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="_order")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	private Date date;
	private String address;
	private boolean storePickUp;
	private double total;
	@OneToMany
	private ArrayList<OrderItem> items = new ArrayList<OrderItem>();

	@Enumerated(EnumType.ORDINAL)
	private OrderState state;

	public Order() {

	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
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

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}
}