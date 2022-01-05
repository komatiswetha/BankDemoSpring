package com.BankDemoSpring.BankDemoSpring.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_details")

public class AccountDetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int acctNumber;
    private double balance;
    private Date date;


    //@OneToOne(mappedBy = "account_details")
    @JoinColumn
    private TransactionDetails transaction_details;

}
