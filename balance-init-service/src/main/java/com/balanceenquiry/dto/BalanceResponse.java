package com.balanceenquiry.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BalanceResponse {

    private String customerName;
    private String email;
    private String contactNumber;
	private String accoundNumber;
	private Double balance;

}
