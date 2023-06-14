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

	@Lob
	@Column(length = 20971520)
	private byte[] logoImage;

	@Column(nullable = false)
	private String postCode;

	@Column(nullable = false)
	private String schedule;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<SocialNetwork> socialNetworks = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private static Company instance;

	public Company() {}

	public Company(String name, String email, String contact, String address, byte[] logoImage, String postCode, String schedule) {
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.logoImage = logoImage;
		this.postCode = postCode;
		this.schedule = schedule;
		Company.instance = this;
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

	public byte[] getLogoImage() {
		return this.logoImage;
	}

	public void setLogoImage(byte[] logoImage) {
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

	public static Company getInstance() {
		return instance;
	}
}