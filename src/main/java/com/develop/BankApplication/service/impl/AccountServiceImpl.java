package com.develop.BankApplication.service.impl;

import com.develop.BankApplication.Exceptions.AccountNotFoundException;
import com.develop.BankApplication.Exceptions.InsufficientFundsException;
import com.develop.BankApplication.dto.AccountDto;
import com.develop.BankApplication.dto.DepositDto;
import com.develop.BankApplication.entity.Account;
import com.develop.BankApplication.mapper.AccountMapper;
import com.develop.BankApplication.repository.AccountRepository;
import com.develop.BankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account Not Found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, DepositDto depositDto) {
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account Not Found"));
        double totalAmount = account.getBalance() + depositDto.getAmount();
        account.setBalance(totalAmount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, DepositDto depositDto) throws InsufficientFundsException {
        Account account = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account Not Found Exception"));
        if(account.getBalance() >= depositDto.getAmount()) {
            double totalAmount = account.getBalance() - depositDto.getAmount();
            account.setBalance(totalAmount);
            Account savedAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(savedAccount);
        }else {
            throw new InsufficientFundsException(String.format("Insufficient Balance To make the withdrawal, Your Balance is : %d", account.getBalance()));
        }
    }
}
