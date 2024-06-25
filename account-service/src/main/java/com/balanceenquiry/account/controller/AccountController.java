package com.balanceenquiry.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balanceenquiry.account.entity.Account;
import com.balanceenquiry.account.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("{accountId}/balance")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable  Long accountId){
		log.info("Entering in getAccountByAccountId Method...");
		Account account= accountService.getAccountByAccountId(accountId);
		 log.info("Account fetched Successfully..!!!");
		 return ResponseEntity.ok(account);
	}
	
	@GetMapping("/balance")
	public ResponseEntity<Account> getAccountByAccountNumber(@RequestParam String accountNumber){
		log.info("Entering in getAccountByAccountNumber Method...");
		Account account= accountService.getAccountByAccountNumber(accountNumber);
		 log.info("Account fetched Successfully..!!!");
		 return ResponseEntity.ok(account);
	}
	
	 @PostMapping("/create")
	 private ResponseEntity<Account> createUser(@RequestBody Account account){
		 log.info("createUser account..!!!");
	       Account acc= accountService.createAccount(account);
	       log.info(" account created successfully..!!!");
	       return ResponseEntity.status(HttpStatus.CREATED).body(acc);
	    }
	 
	 @GetMapping()
		public ResponseEntity<List<Account>> getAllAccounts(){
		 log.info(" Entering in getAllAccountst..!!!");
		 List<Account> accounts= accountService.getAllAccounts();
		 log.info("Account fetched Successfully..!!!");
			 return ResponseEntity.ok(accounts);
		}
	 
		
}
