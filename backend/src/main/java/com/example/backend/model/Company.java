package com.example.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String contact;

	@Column(nullable = false)
	private String address;
	private String logoImage;

	@Column(nullable = false)
	private String postCode;

	@Column(nullable = false)
	private String schedule;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<SocialNetwork> socialNetworks = new ArrayList<>();

	public Company() {}

	public Company(String name, String email, String contact, String address, String logoImage, String postCode, String schedule) {
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.logoImage = logoImage;
		this.postCode = postCode;
		this.schedule = schedule;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
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

	public List<SocialNetwork> getSocialNetworks() {
		return socialNetworks;
	}

	public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
}