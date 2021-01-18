package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositDao extends JpaRepository<Deposit, Long> {}
