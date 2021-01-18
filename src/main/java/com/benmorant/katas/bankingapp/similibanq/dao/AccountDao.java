package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {}
