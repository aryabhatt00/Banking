package com.bankingprojectnew.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bankingprojectnew.Entity.Account;
import com.bankingprojectnew.Entity.BankTransaction;
import com.bankingprojectnew.Entity.BankTransactionType;
import com.bankingprojectnew.Entity.Customer;

public class BankingService {

    private static SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Account.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(BankTransaction.class)
            .configure()
            .buildSessionFactory();
    
    public static void withdraw(int accountId, int amount) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Account account = session.get(Account.class, accountId);

        if (account != null) { 
            if (account.getAccountBalance() >= amount) {
                account.setAccountBalance(account.getAccountBalance() - amount);

                BankTransaction transaction = 
                        new BankTransaction(BankTransactionType.WITHDRAWAL, amount, account);

                session.persist(transaction);
                session.merge(account);
                
                tx.commit();
                System.out.println("Withdrawal of $" + amount + " from Account ID: " + accountId + " is successful.");
            } else {
                System.out.println("Insufficient balance! Withdrawal failed.");
            }
        } else {
            System.out.println("Account not found!");
        }
        
        session.close();
    }

    public static void deposit(int accountId, int amount) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Account account = session.get(Account.class, accountId);

        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);

            BankTransaction transaction = 
                    new BankTransaction(BankTransactionType.DEPOSIT, amount, account);

            session.persist(transaction);
            session.merge(account);
            
            tx.commit();
            System.out.println("The amount successfully credited to your account!");
            System.out.println("Updated Account Balance: $" + account.getAccountBalance());
        } else {
            System.out.println("Account not found!");
        }
        
        session.close();
    }
}

