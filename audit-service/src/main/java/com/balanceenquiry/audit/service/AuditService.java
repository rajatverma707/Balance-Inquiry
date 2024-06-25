package com.balanceenquiry.audit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.balanceenquiry.audit.entity.AuditLog;
import com.balanceenquiry.audit.entity.AuditLogRequest;
import com.balanceenquiry.audit.repository.AuditLogRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuditService {

	@Autowired
	AuditLogRepository auditLogRepository;

    public String logAudit(AuditLogRequest auditLogRequest) {
    	 log.info("*** Message String, AuditService; logAudit *");
    	AuditLog auditLog = new AuditLog();
        auditLog.setTimestamp( LocalDateTime.now());
        auditLog.setAction(auditLogRequest.getAction());
        auditLog.setAccountId(auditLogRequest.getAccountId());
        auditLogRepository.save(auditLog);
        return "Audit log saved successfully";
    }
    
    public  List<AuditLog>  getAllLogAuditEvent(){
    	log.info("*** AuditLog List, AuditService; getAllLogAuditEvent *");
    	return auditLogRepository.findAll();
    }

}
