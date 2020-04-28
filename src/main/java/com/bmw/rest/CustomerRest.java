package com.bmw.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bmw.entity.Customer;
import com.bmw.service.CustomerService;
import com.bmw.service.QueryService;

@Path("customer")  //url/car2/resources/customer
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRest {

	@Inject
	CustomerService customerService; 
	
	@Inject
	QueryService queryService;
	
	
	@Path("create")  // url/car2/customer/create
	@POST
	public Response create(Customer customer) {
		customerService.create(customer);
		return Response.ok(customer).build();
	}
	
	@Path("list") // url/car2/customer/list
	@GET
	public Response findAllCustomers() {
		return Response.ok(queryService.findAllCustomers()).build();
	}
	
	
	@Path("pattern")   // url/car2/customer/pattern/name=?
	@GET
	public Response findCustomerByPattern(@QueryParam("name") String name) {
		Collection<Customer> result = queryService.findCustomerByPattern(name);
		return Response.ok(result).build();
	}
}
