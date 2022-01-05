package com.BankDemoSpring.BankDemoSpring.service;

import com.BankDemoSpring.BankDemoSpring.model.TransactionDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    public void saveDetails(TransactionDetails transactionDetails);
    public  TransactionDetails getDetails(int id);
    public List<TransactionDetails> findTransactionsByAccountNumber(int id);


}
