package com.swordcode.laboratorio2;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private String name;
	private String email;
	private String country;
	private String id;
	private String company;
	private String food;
	private String pet;
	private String profession;
	private String gender;
	private String comment;

	public UserInfo() {
	}

	public UserInfo(String name) {
		this.name = name;
	}

	public UserInfo(String name, String email, String country, String id, String company, String food, String pet,
			String profession, String gender, String comment) {
		this.name = name;
		this.email = email;
		this.country = country;
		this.id = id;
		this.company = company;
		this.food = food;
		this.pet = pet;
		this.profession = profession;
		this.gender = gender;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
}