package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class SocialNetwork {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int iD;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String link;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;


	public SocialNetwork() {

	}

	public SocialNetwork(String name, String link, Company company) {
		this.name = name;
		this.link = link;
		this.company = company;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
}