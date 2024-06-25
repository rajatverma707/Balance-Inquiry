package com.balanceenquiry.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value =AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException accountNotFoundException) {
        return new ResponseEntity<String>("Accound not found", HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(value =CustomerNotFoundExxception.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundExxception customerNotFoundExxception) {
        return new ResponseEntity<String>("Customer not found", HttpStatus.NOT_FOUND);
    }


}
