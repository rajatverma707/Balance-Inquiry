package com.balanceenquiry.account.controller;

import java.util.List;

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

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("{accountId}/balance")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable  Long accountId){
		Account account= accountService.getAccountByAccountId(accountId);
		 return ResponseEntity.ok(account);
	}
	
	@GetMapping("/balance")
	public ResponseEntity<Account> getAccountByAccountNumber(@RequestParam String accountNumber){
		Account account= accountService.getAccountByAccountNumber(accountNumber);
		 return ResponseEntity.ok(account);
	}
	
	 @PostMapping("/create")
	 private ResponseEntity<Account> createUser(@RequestBody Account account){
		
	       Account acc= accountService.createAccount(account);
	       return ResponseEntity.status(HttpStatus.CREATED).body(acc);
	    }
	 
	 @GetMapping()
		public ResponseEntity<List<Account>> getAllAccounts(){
		 List<Account> accounts= accountService.getAllAccounts();
			
			 return ResponseEntity.ok(accounts);
		}
	 
		
}
