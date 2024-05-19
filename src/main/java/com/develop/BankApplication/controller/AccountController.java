package com.develop.BankApplication.controller;

import com.develop.BankApplication.Response.ApiResponse;
import com.develop.BankApplication.dto.AccountDto;
import com.develop.BankApplication.dto.DepositDto;
import com.develop.BankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ApiResponse<AccountDto>> createAccount(@RequestBody AccountDto accountDto)
    {
        AccountDto accountDto1 = accountService.createAccount(accountDto);
        ApiResponse<AccountDto> apiResponse = new ApiResponse<>("account created!",200,accountDto1);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountDto>> getAccount(@PathVariable Long id)
    {
        AccountDto accountDto = accountService.getAccount(id);
        ApiResponse<AccountDto> apiResponse = new ApiResponse<>("account fetched!",200,accountDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/deposit/{id}")
    public ResponseEntity<ApiResponse<AccountDto>> depositToAccount(@PathVariable Long id, @RequestBody DepositDto depositDto)
    {
        AccountDto accountDto = accountService.deposit(id,depositDto);
        ApiResponse<AccountDto> response = new ApiResponse<>("Deposit successful", HttpStatus.OK.value(), accountDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/withdraw/{id}")
    public ResponseEntity<ApiResponse<AccountDto>> withdrawFromAccount(@PathVariable Long id, @RequestBody DepositDto depositDto)
    {
        AccountDto accountDto = accountService.withdraw(id,depositDto);
        ApiResponse<AccountDto> response = new ApiResponse<>("Withdrawal successful", HttpStatus.OK.value(), accountDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<AccountDto>>> getAllAccounts()
    {
        List<AccountDto> accounts = accountService.getAllAccounts();
        ApiResponse<List<AccountDto>> apiResponse = new ApiResponse<>("successfully Fetched Accounts!",200,accounts);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        ApiResponse<String> apiResponse = new ApiResponse<>("Deleted Successfully",200,"");
        return ResponseEntity.ok(apiResponse);
    }


}
