package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Long> {}
