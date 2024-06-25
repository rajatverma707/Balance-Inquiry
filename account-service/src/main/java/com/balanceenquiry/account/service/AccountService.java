package com.balanceenquiry.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.balanceenquiry.account.entity.Account;
import com.balanceenquiry.account.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired 
	AccountRepository accountRepository;

	public Account getAccountByAccountId(Long accountId){
		return accountRepository.findById(accountId).get();
	}
	
	public Account getAccountByAccountNumber(String accountNumber){
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	public Account createAccount(Account account) {
		 return accountRepository.save(account);
	}

	
	public List<Account> getAllAccounts() {
		 return accountRepository.findAll();
	}

}
