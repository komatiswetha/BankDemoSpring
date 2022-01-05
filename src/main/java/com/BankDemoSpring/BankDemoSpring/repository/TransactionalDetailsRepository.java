package com.BankDemoSpring.BankDemoSpring.repository;

import com.BankDemoSpring.BankDemoSpring.model.AccountDetails;
import com.BankDemoSpring.BankDemoSpring.model.TransactionDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionalDetailsRepository extends CrudRepository<TransactionDetails,Integer> {
       @Query(value = "select acctNumber from TransactionalDetails where id=?1 ",nativeQuery = true)
      public Optional<List<TransactionDetails>> findByAccountNumber(int id);

}
