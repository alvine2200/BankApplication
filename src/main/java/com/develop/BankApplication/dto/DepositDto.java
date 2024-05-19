package com.develop.BankApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepositDto {
    private Long id;
    private double amount;
}
