package com.bankingprojectnew.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bankingprojectnew.Entity.BankTransaction;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Integer> {
}
