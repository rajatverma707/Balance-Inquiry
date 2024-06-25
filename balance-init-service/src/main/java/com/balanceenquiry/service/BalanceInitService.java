package com.balanceenquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balanceenquiry.client.AccountClient;
import com.balanceenquiry.client.AuditLogClient;
import com.balanceenquiry.client.CustomerClient;
import com.balanceenquiry.client.NotificationClient;
import com.balanceenquiry.dto.Account;
import com.balanceenquiry.dto.AuditLogRequest;
import com.balanceenquiry.dto.BalanceResponse;
import com.balanceenquiry.dto.Customer;
import com.balanceenquiry.dto.NotificationRequest;
import com.balanceenquiry.exception.AccountNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BalanceInitService {
	

	@Autowired
	AccountClient accountClient;

	@Autowired
	CustomerClient customerClient;
	
	@Autowired
	AuditLogClient auditLogClient;
	
	@Autowired
	NotificationClient notificationClient;
	
    public BalanceResponse fetchAccountBalance(Long accountId) {
    	log.info("*** BalanceResponse, BalanceInitService; fetchAccountBalance *");
        // Logic to fetch account balance from account service or database
    	String customerName = "";
    	String action= "Account balance inquiry";
    	
    	// calling account service
    	log.info("*** calling account service to get account details  *");
        Account account = accountClient.getAccountByAccountId(accountId).getBody();
        Customer customer = new Customer();
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setAccoundNumber(account.getAccountNumber());
        balanceResponse.setBalance(account.getBalance());
        if(account!= null && account.getCustomerId() != null) {
        	
        // calling customer service to get customer details
        	log.info("*** calling customer service to get customer details  *");
        	customer = customerClient.getCustomerById(account.getCustomerId()).getBody();
        	log.info("*** Fetched customer service to get customer details  *"+customer.toString());
        	if(customer!= null) {
        		customerName = customer.getFirstName()+" "+customer.getLastName();
        		balanceResponse.setCustomerName(customerName);
        		balanceResponse.setContactNumber(customer.getContactNumber());
        		balanceResponse.setEmail(customer.getEmail());
        	}
        }else {
        	throw new AccountNotFoundException("Account not found");
        }
        // Calling audit log service
        log.info("*** calling audit log service  *");
        auditLogClient.logAuditEvent(new AuditLogRequest(account.getId().toString(),action));
        
        // Sending notification 
        log.info("*** calling  notification  service to send  notification   *");
        String message= "Hi "+customerName+","+"\n"+ "Your account balance inquiry was successful. Your current balance is "+account.getBalance()+".";
        notificationClient.sendNotification(new NotificationRequest(customer.getEmail(),message));
        log.info("*** Notification sent *");
		return balanceResponse;
       
     
    }

}
