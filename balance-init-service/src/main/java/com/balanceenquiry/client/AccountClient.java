package com.balanceenquiry.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.balanceenquiry.dto.Account;


@FeignClient("ACCOUNT-SERVICE")
public interface AccountClient {
	
	@GetMapping("accounts/{accountId}/balance")
	ResponseEntity<Account> getAccountByAccountId(@PathVariable("accountId") Long accountId);
	
	}

