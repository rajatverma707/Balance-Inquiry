package com.balanceenquiry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceInitiateRequestDTO {
	
	private Long customerId;
	private String password;

}
