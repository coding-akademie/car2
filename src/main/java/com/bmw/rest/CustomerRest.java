package com.bmw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.bmw.entity.Customer;
import com.bmw.service.CustomerService;

@Path("customer")  //url/car2/resources/customer
public class CustomerRest {

	@Inject
	CustomerService customerService; 
	
	
	@Path("create")  // url/car2/customer/create
	@POST
	public Response create(Customer customer) {
		customerService.create(customer);
		return Response.ok(customer).build();
	}
	
	
}
