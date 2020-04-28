package com.bmw.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bmw.entity.Customer;

@Stateless
public class CustomerService {

	@PersistenceContext   
	EntityManager entityManager;
	
	@Inject
	QueryService queryService;
	
	// Create
		public Customer create(Customer customer) {
			
			List list = queryService.countCustomerByEmail(customer.getEmail());
			Integer count = (Integer) list.get(0);
			
			if(customer.getId() == null && count == 0) {
			entityManager.persist(customer);
			
		}
	
			return customer;
		}
}
