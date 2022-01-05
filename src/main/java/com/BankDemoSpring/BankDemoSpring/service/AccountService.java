package com.BankDemoSpring.BankDemoSpring.service;

import com.BankDemoSpring.BankDemoSpring.model.AccountDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    public void saveAccount(AccountDetails accountDetails);
    public AccountDetails getAccountInfo(int id);
    public int getBalance(int acctNumber);
    public void depositAmount(int id, int acctNumber, double amount);
    public void withdrawAmount(int id, int acctNumber, double amount);












}
