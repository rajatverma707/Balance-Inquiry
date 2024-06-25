package com.balanceenquiry.audit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balanceenquiry.audit.entity.AuditLog;
import com.balanceenquiry.audit.entity.AuditLogRequest;
import com.balanceenquiry.audit.repository.AuditLogRepository;

@Service
public class AuditService {

	@Autowired
	AuditLogRepository auditLogRepository;

    public String logAudit(AuditLogRequest auditLogRequest) {
    	AuditLog auditLog = new AuditLog();
        // Assign a unique ID to the audit log entry
        //auditLog.setId(++auditId);
        auditLog.setTimestamp( LocalDateTime.now());
        auditLog.setAction(auditLogRequest.getAction());
        auditLog.setAccountId(auditLogRequest.getAccountId());
        // Log the audit entry (for demo purposes, print to console)
        System.out.println("Audit Log: " + auditLog.toString());
        // In a production environment, you would persist this audit log to a database or a log file.
        // Example: auditLogRepository.save(auditLog);
        auditLogRepository.save(auditLog);

         return "Audit log saved successfully";
    }
    
    public  List<AuditLog>  getAllLogAuditEvent(){
    	return auditLogRepository.findAll();
    }

}
