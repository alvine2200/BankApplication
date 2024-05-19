package com.develop.BankApplication.service.impl;

import com.develop.BankApplication.dto.AccountDto;
import com.develop.BankApplication.entity.Account;
import com.develop.BankApplication.mapper.AccountMapper;
import com.develop.BankApplication.repository.AccountRepository;
import com.develop.BankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


//    public AccountServiceImpl(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not Found"));
        return AccountMapper.mapToAccountDto(account);
    }
}
