package com.balanceenquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balanceenquiry.dto.Account;
import com.balanceenquiry.dto.BalanceRequest;
import com.balanceenquiry.dto.BalanceResponse;
import com.balanceenquiry.service.BalanceInitService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class BalanceInitController {
	  
		@Autowired
		BalanceInitService balanceInitService;

	    @PostMapping("balance/initiate")
	    @CircuitBreaker(name = "AccountCicruitBreaker",fallbackMethod = "accountFallBack")
	    public ResponseEntity<BalanceResponse> initiateBalanceCheck(@RequestBody BalanceRequest request) {
	        BalanceResponse response = balanceInitService.fetchAccountBalance(request.getAccoundId());
	        if (response != null) {
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    

		public ResponseEntity<Account> accountFallBack(Long accountId,Exception ex){
			Account account =	Account.builder()
								.accountNumber("542154545454545")
								.accountType("Dummy Account")
								.customerId(1L)
								.balance(878787.0)
								.build();
			 return ResponseEntity.ok(account);
		}

}
