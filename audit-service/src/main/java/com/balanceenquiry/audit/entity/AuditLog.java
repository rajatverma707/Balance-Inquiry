package com.balanceenquiry.audit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auditLog")
public class AuditLog {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditLog_id")
    private Long id;

    @Column(name = "account_Id")
    private String accountId;

    @Column(name = "time_stamp")
    private LocalDateTime timestamp;
    
    @Column(name = "action")
    private String action;

  
}
