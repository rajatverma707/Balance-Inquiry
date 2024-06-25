package com.balanceenquiry.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.balanceenquiry.account.entity.Account;
import com.balanceenquiry.account.repository.AccountRepository;
import com.balanceenquiry.exception.AccountNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {
	
	@Autowired 
	AccountRepository accountRepository;

	public Account getAccountByAccountId(Long accountId){
		 log.info("*** Account, service; getAccountByAccountId *");
		return accountRepository.findById(accountId).orElseThrow(()->  new AccountNotFoundException("Account not found with accoundId "+accountId));
	}
	
	public Account getAccountByAccountNumber(String accountNumber){
		 log.info("*** Account, service; getAccountByAccountNumber *");
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	public Account createAccount(Account account) {
		log.info("*** Account, service; create Account *");
		 return accountRepository.save(account);
		 
	}
	
	public List<Account> getAllAccounts() {
		log.info("*** Account List, service; getAllAccounts *");
		 return accountRepository.findAll();
	}

}
