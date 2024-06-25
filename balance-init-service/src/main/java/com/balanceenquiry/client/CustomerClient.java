package com.balanceenquiry.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.balanceenquiry.dto.Customer;


@FeignClient("CUSTOMER-SERVICE")
public interface CustomerClient {
	
	@GetMapping("customers/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  Long customerId) ;

}
