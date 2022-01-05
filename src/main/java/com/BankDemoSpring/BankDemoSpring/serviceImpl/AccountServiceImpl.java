package com.BankDemoSpring.BankDemoSpring.serviceImpl;

import com.BankDemoSpring.BankDemoSpring.model.AccountDetails;
import com.BankDemoSpring.BankDemoSpring.repository.AccountRepository;
import com.BankDemoSpring.BankDemoSpring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void saveAccount(AccountDetails accountDetails) {
        accountRepository.save(accountDetails);

    }

    @Override
    public AccountDetails getAccountInfo(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public int getBalance(int id) {

        return accountRepository.findBalanceByAcctNumber(id);
    }

    @Override
    public void depositAmount(int id, int acctNumber, double amount) {
        accountRepository.saveBalanceByAcctID(id,amount);

    }

    @Override
    public void withdrawAmount(int id, int acctNumber, double amount) {
        accountRepository.withdrawAmountByAcctID(id,amount);

    }


}
