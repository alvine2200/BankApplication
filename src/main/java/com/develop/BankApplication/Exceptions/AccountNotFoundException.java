package com.develop.BankApplication.Exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException (String message)
    {
        super(message);
    }
}
