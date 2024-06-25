package com.balanceenquiry.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	    private Long id;
	    private String accountNumber;
	    private Double balance;
	    private String accountType;
	    private LocalDateTime openedAt;
	    private Long customerId;
}
