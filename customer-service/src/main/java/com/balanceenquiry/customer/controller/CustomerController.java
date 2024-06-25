package com.balanceenquiry.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balanceenquiry.customer.entity.Customer;
import com.balanceenquiry.customer.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable  Long customerId) {
		Customer customer= customerService.getCustomerById(customerId);
	 return  new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer>  getCustomer(@RequestBody  Customer customer) {
		customerService.createCustomer(customer);
		return  new ResponseEntity<>(customer,HttpStatus.CREATED);
	
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.fetchAllCustomers();
		return ResponseEntity.ok(customers);
	}

}
