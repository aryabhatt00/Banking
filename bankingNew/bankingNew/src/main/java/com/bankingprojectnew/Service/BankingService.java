package com.bankingprojectnew.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bankingprojectnew.Entity.Account;
import com.bankingprojectnew.Repository.AccountRepository;
import com.bankingprojectnew.Repository.BankTransactionRepository;

@Service
public class BankingService {
	
	@Autowired 
	private AccountRepository accountRepository;
    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    @Transactional
    public String deposit(int accountId, int amount) {
    	
    	Optional<Account> optionalAccount= accountRepository.findById(accountId);
    	if (optionalAccount.isPresent()) {
    	    Account account = optionalAccount.get();
    	    account.setAccountBalance(account.getAccountBalance()+amount);
    	    accountRepository.save(account);
    	    return "Deposit successful. New balance: $" + account.getAccountBalance();   
    	} else {   
    	    return("Account not found!");
    	}	
    }
    
    @Transactional
    public String withdraw(int accountId, int amount) {
    	
    	Optional<Account> optionalAccount= accountRepository.findById(accountId);
    	if (optionalAccount.isPresent()) {
    	    Account account = optionalAccount.get();
    	    if(account.getAccountBalance()>=amount) {
    	    account.setAccountBalance(account.getAccountBalance()-amount);
    	    accountRepository.save(account);
    	    return "Withdraw successful. New balance: $" + account.getAccountBalance();   
    	    }
    	    else {
    	    	return("Account limit is lower than $"+amount);
    	    }
    	    
    	    } else {   
    	    return("Account not found!");
    	}	
    }
}

