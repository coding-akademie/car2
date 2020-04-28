package com.bmw.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bmw.entity.Customer;

@Stateless
public class CustomerService {

	@PersistenceContext   
	EntityManager entityManager;
	
	
	// Create
		public Customer create(Customer customer) {
			entityManager.persist(customer);
			return customer;
		}
	
}
