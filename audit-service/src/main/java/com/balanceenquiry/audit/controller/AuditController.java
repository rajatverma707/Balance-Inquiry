package com.balanceenquiry.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balanceenquiry.audit.entity.AuditLog;
import com.balanceenquiry.audit.entity.AuditLogRequest;
import com.balanceenquiry.audit.service.AuditService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/audit")
public class AuditController {

	    @Autowired
	    private AuditService auditService;

	    @PostMapping("/log")
	    public ResponseEntity<String> logAuditEvent(@RequestBody AuditLogRequest auditLog) {
	    log.info("*** Message String, AuditController; logAuditEvent *");
	     String statusMessage =  auditService.logAudit(auditLog);
	        return ResponseEntity.ok(statusMessage);
	    }
	    
	    @GetMapping("/logs")
	    public ResponseEntity<List<AuditLog>> getLogAuditEvent() {
	    	 log.info("*** AuditLog List, AuditController; getLogAuditEvent *");
	    	List<AuditLog> list =auditService.getAllLogAuditEvent();
	    	return ResponseEntity.ok(list);
	    }
}
