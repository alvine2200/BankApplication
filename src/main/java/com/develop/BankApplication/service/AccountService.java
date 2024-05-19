package com.develop.BankApplication.service;

import com.develop.BankApplication.Exceptions.InsufficientFundsException;
import com.develop.BankApplication.dto.AccountDto;
import com.develop.BankApplication.dto.DepositDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccount(Long id);

    AccountDto deposit(Long id, DepositDto depositDto);

    AccountDto withdraw(Long id, DepositDto depositDto) throws InsufficientFundsException;
}
