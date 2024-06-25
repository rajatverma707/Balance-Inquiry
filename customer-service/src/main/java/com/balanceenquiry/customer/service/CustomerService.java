package com.balanceenquiry.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balanceenquiry.customer.entity.Customer;
import com.balanceenquiry.customer.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
    }
	
	public List<Customer> fetchAllCustomers() {
		return customerRepository.findAll();
	}
}
