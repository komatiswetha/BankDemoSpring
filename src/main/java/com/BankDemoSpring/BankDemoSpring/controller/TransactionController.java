package com.BankDemoSpring.BankDemoSpring.controller;

import com.BankDemoSpring.BankDemoSpring.model.TransactionDetails;
import com.BankDemoSpring.BankDemoSpring.serviceImpl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    public void saveDetails(TransactionDetails transactionDetails) {
        transactionService.saveDetails(transactionDetails);
    }

    public List<TransactionDetails> findTransactionsByAccountNumber(int id) {
        return transactionService.findTransactionsByAccountNumber(id);
    }
}
