package com.balanceenquiry.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.balanceenquiry.notification.model.NotificationRequest;

@Service
public class NotificationService {
	
	@Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;
    
    @Value("${notification.mail.subject}")
    private String emailSubject;
    
    @Value("${notification.mail.message}")
    private String emailMessage;
	
	 public void sendNotification(NotificationRequest notificationRequest) {
	        try {
	            SimpleMailMessage mailMsg = new SimpleMailMessage();
	            mailMsg.setFrom(emailSender);
	            mailMsg.setTo(notificationRequest.getRecipient());
	            mailMsg.setText(notificationRequest.getMessage());
	            mailMsg.setSubject(emailSubject);
	            javaMailSender.send(mailMsg);
	           // log.info("Mail sent successfully");
	        }catch (MailException exception){
	         //   log.debug("Failure occurred while sending email");
	        }
	    }
	    
}
