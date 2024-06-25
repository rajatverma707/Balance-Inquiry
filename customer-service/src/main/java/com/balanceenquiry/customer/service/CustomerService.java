package com.balanceenquiry.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balanceenquiry.customer.entity.Customer;
import com.balanceenquiry.customer.exception.CustomerNotFoundExxception;
import com.balanceenquiry.customer.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomerById(Long customerId) {
		log.info("*** Customer, CustomerService; get Customer by ID*");
		return customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundExxception("Customer not found"));
	}
	
	public Customer createCustomer(Customer customer) {
		log.info("*** Customer, CustomerService; create Customer*");
		return customerRepository.save(customer);
    }
	
	public List<Customer> fetchAllCustomers() {
		log.info("*** Customer List, CustomerService; get all customers *");
		return customerRepository.findAll();
	}
}
