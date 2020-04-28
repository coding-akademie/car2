package com.bmw.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bmw.entity.Customer;

@Stateless
public class QueryService {

	@PersistenceContext
	EntityManager entityManager;

	public List<Customer> findAllCustomers() {

		return entityManager
				.createNamedQuery(Customer.ALL, Customer.class)
				.getResultList();
	}
	
	public Collection<Customer> findCustomerByPattern(String name){
		return entityManager
				.createNamedQuery(Customer.BY_PATTERN)
				.setParameter("name", name)
				.getResultList();
	}
	
	
	
	
}
