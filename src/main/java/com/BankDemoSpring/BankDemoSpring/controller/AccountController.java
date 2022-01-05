package com.BankDemoSpring.BankDemoSpring.controller;

import com.BankDemoSpring.BankDemoSpring.model.AccountDetails;
import com.BankDemoSpring.BankDemoSpring.model.TransactionDetails;
import com.BankDemoSpring.BankDemoSpring.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {
@Autowired
public AccountServiceImpl accountServiceImpl;

@Autowired
private TransactionController transactionController;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;

    }

    @PostMapping("/createAccount")
    public  AccountDetails saveAccount(@RequestBody AccountDetails accountDetails){
    accountServiceImpl.saveAccount(accountDetails);
    return accountDetails;
}
    @GetMapping("/account/{id}/balance")
    public int getBalance(@PathVariable int id)
    {
        return accountServiceImpl.getBalance(id);
    }

    @PutMapping("/account/{id}/{acctNumber}/deposit/{amount}")
    public void depositAmount(@PathVariable int id,@PathVariable int acctNumber, @PathVariable int amount) {
        int initialBalance = getBalance(id);
        accountServiceImpl.depositAmount(id,acctNumber, amount);
        TransactionDetails transactionDetails=new TransactionDetails(id,acctNumber,"Deposited", "Success", initialBalance, initialBalance + amount);
       transactionController.saveDetails(transactionDetails);

    }
    @PutMapping("/account/{id}/{acctNumber}/withdraw/{amount}")
    public void withdrawAmount(@PathVariable int id, @PathVariable int acctNumber,@PathVariable int amount) {
        int initialBalance = getBalance(id);
        accountServiceImpl.withdrawAmount(id,acctNumber, amount);
        TransactionDetails transactionDetails=new TransactionDetails(id,acctNumber,"Withdrawn","Success",initialBalance,initialBalance-amount);
        transactionController.saveDetails(transactionDetails);
    }

    @GetMapping("/account/{id}")
    public AccountDetails getAccountInfo(@PathVariable int id) {

        return accountServiceImpl.getAccountInfo(id);
    }
    @GetMapping("account/transactions/{id}")
    public List<TransactionDetails> getTransactionsByAccountNumber(@PathVariable int id){
        //getTransactionsByAccountNumber(id);
       return transactionController.findTransactionsByAccountNumber(id);


    }
    }
