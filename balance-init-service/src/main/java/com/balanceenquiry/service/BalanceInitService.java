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
        // Logic to fetch account balance from account service or database
    	String customerName = "";
    	String action= "Account balance inquiry";
        Account account = accountClient.getAccountByAccountId(accountId).getBody();
        Customer customer = new Customer();
        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setAccoundNumber(account.getAccountNumber());
        balanceResponse.setBalance(account.getBalance());
        if(account.getCustomerId() != null) {
        	customer = customerClient.getCustomerById(account.getCustomerId()).getBody();
        	if(customer!= null) {
        		customerName = customer.getFirstName()+" "+customer.getLastName();
        		balanceResponse.setCustomerName(customerName);
        		balanceResponse.setContactNumber(customer.getContactNumber());
        		balanceResponse.setEmail(customer.getEmail());
        	}
        }
        // Calling audit log service
        auditLogClient.logAuditEvent(new AuditLogRequest(account.getId().toString(),action));
        
        // Sending notification 
        String message= "Hi "+customerName+","+"\n"+ "Your account balance inquiry was successful. Your current balance is "+account.getBalance()+".";
        notificationClient.sendNotification(new NotificationRequest(customer.getEmail(),message));
        
		return balanceResponse;
       
     
    }

}
