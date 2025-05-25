package com.bankingprojectnew.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bankingprojectnew.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
   
}
