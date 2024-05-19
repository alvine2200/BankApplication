package com.develop.BankApplication.controller;

import com.develop.BankApplication.dto.AccountDto;
import com.develop.BankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id)
    {
        AccountDto accountDto = accountService.getAccount(id);
        return ResponseEntity.ok(accountDto);
    }


}
