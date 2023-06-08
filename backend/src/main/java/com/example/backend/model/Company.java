package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	private String name;
	private String email;
	private int contact;
	private String address;
	private String logoImage;
	private String postCode;
	private String schedule;

	@OneToMany
	private ArrayList<SocialNetwork> socialNetworks = new ArrayList<SocialNetwork>();

	public Company() {

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact() {
		return this.contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogoImage() {
		return this.logoImage;
	}

	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getSchedule() {
		return this.schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<SocialNetwork> getSocialNetworks() {
		return socialNetworks;
	}

	public void setSocialNetworks(ArrayList<SocialNetwork> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}
}