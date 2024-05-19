package com.develop.BankApplication.service;

import com.develop.BankApplication.dto.AccountDto;
import com.develop.BankApplication.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccount(Long id);
}
