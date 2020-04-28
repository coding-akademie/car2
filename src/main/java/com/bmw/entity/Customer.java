package com.bmw.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@NamedQuery(name = Customer.ALL, query = "select c from Customer c")
@NamedQuery(name = Customer.BY_PATTERN, 
query = "select c from Customer c where c.name like :name ")

@NamedQuery(name = Customer.BY_EMAIL, 
query = "select c from Customer c where c.email = :email ")

@Table(name = "CustomerTable")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public static final String ALL = "find.AllCustomers";
	public static final String BY_PATTERN = "Customer.ByPattern";
	public static final String BY_EMAIL = "Customer.ByEMAIL";
	
	private String name; // NAME

	// @NotEmpty(message = "Email darf nicht leer sein!")
	private String email; // EMAIL

	private LocalDate createdDate;
	private boolean active;
	public Long getId() {
		return id;
	}
	
	@PrePersist
	private void initDate() {
		setCreatedDate(LocalDate.now());
		// createDate = LocalDate.now();
	}
	
	public void setId(Long id) {
		this.id = id;
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
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
