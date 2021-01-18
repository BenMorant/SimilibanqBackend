package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import com.benmorant.katas.bankingapp.similibanq.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
  List<Account> findByCustomer(Customer customer);
}
