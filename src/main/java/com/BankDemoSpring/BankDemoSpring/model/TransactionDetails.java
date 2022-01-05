package com.BankDemoSpring.BankDemoSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction_details",catalog = "bankdemospring")
public class TransactionDetails implements Serializable {
    //@JoinColumn(name = "account_details_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //AccountDetails accountDetails;
    private int id;
    private int acctNumber;
    private String transacType;
    private String transacStatus;
    private double initialBalance;
    private double finalBalance;
    private Date date;

    //@JoinColumn
    //private AccountDetails account_details;

    public TransactionDetails(int id, int acctNumber, String transacType, String transacStatus, double initialBalance, double finalBalance) {
        this.id = id;
        this.acctNumber = acctNumber;
        this.transacType = transacType;
        this.transacStatus = transacStatus;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }
}
