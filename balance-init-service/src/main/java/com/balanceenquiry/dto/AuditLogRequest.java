package com.balanceenquiry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogRequest {
	
	  private String accountId;
	  private String action;

}
