package com.balanceenquiry.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balanceenquiry.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByAccountNumber(String accountNumber);

}
