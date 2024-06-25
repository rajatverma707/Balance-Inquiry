package com.balanceenquiry.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.balanceenquiry.dto.NotificationRequest;



@FeignClient("NOTIFICATION-SERVICE")
public interface NotificationClient {
	
	@PostMapping("notifications/send")
    public ResponseEntity<?> sendNotification(@RequestBody NotificationRequest request);
}
