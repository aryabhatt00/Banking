package com.bankingprojectnew.Entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class BankTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account transactionAccount;
    
    private int transactionAmount;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Enumerated(EnumType.STRING)
    private BankTransactionType transactionType;

    public BankTransaction() {
        this.transactionDate = new Date();
    }

    public BankTransaction(BankTransactionType transactionType, int transactionAmount, Account transactionAccount) {
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionAccount = transactionAccount;
        this.transactionDate = new Date();
    }
    
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public Account getTransactionAccount() {
        return transactionAccount;
    }
    public void setTransactionAccount(Account transactionAccount) {
        this.transactionAccount = transactionAccount;
    }
    public int getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
