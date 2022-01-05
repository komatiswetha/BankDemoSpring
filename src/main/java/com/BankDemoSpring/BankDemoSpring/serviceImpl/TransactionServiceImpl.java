package com.BankDemoSpring.BankDemoSpring.serviceImpl;

import com.BankDemoSpring.BankDemoSpring.model.AccountDetails;
import com.BankDemoSpring.BankDemoSpring.model.TransactionDetails;
import com.BankDemoSpring.BankDemoSpring.repository.AccountRepository;
import com.BankDemoSpring.BankDemoSpring.repository.TransactionalDetailsRepository;
import com.BankDemoSpring.BankDemoSpring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionalDetailsRepository transactionalDetailsRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void saveDetails(TransactionDetails transactionDetails) {
        transactionalDetailsRepository.save(transactionDetails);

    }

    @Override
    public TransactionDetails getDetails(int id) {

        return transactionalDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<TransactionDetails> findTransactionsByAccountNumber(int id) {
        List<TransactionDetails> transactionDetails = new ArrayList<>();
        Optional<AccountDetails> accountDetails = Optional.ofNullable(accountRepository.getAccountInfo(id));
        if (accountDetails.isPresent()) {
            Optional<List<TransactionDetails>> transactionDetails1 = transactionalDetailsRepository.findByAccountNumber(id);
            if (transactionDetails1.isPresent()) {
                transactionDetails1.get().forEach(transactionDetails2 -> {
                    transactionDetails.add(transactionDetails2);
                });
            }


        }
        return (transactionDetails);

    }
}
