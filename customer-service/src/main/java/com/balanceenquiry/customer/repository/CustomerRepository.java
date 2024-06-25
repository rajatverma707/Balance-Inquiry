package com.balanceenquiry.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balanceenquiry.customer.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
