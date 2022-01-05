package com.BankDemoSpring.BankDemoSpring.repository;

import com.BankDemoSpring.BankDemoSpring.model.AccountDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<AccountDetails, Integer> {


    @Query("select balance from AccountDetails where id = ?1")
    public int findBalanceByAcctNumber(int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update AccountDetails set balance = balance+?2 where id=?1")
    public void saveBalanceByAcctID(int id, double balance);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update AccountDetails set balance = balance-?2 where id=?1")
    public void withdrawAmountByAcctID(int id, double balance);

    @Query(value = "select acctNumber from AccountDetails where id=?1",nativeQuery = true)
    public AccountDetails getAccountInfo(int id);

   }
