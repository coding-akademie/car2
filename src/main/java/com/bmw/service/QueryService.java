package com.bmw.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.NoContentException;

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
	
	
	public Customer findCustomerByEmail(String email) {
		
		try {
		return entityManager.
				createNamedQuery(Customer.BY_EMAIL, Customer.class)
				.setParameter("email", email)
				.getSingleResult() ;
		
		} catch(NonUniqueResultException | NoResultException e) {
			
			return null;
		}
	}
	
	
}
