package com.balanceenquiry.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balanceenquiry.audit.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{

}
