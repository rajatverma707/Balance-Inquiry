package com.balanceenquiry.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.balanceenquiry.dto.AuditLogRequest;



@FeignClient("AUDIT-SERVICE")
public interface AuditLogClient {

	@PostMapping("audit/log")
    public ResponseEntity<String> logAuditEvent(@RequestBody AuditLogRequest auditLogRequest);
}
