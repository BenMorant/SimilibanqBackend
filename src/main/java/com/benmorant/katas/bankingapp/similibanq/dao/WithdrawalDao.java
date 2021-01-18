package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawalDao extends JpaRepository<Withdrawal, Long> {}
