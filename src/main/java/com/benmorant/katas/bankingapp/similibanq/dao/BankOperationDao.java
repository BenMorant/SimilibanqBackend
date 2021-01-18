package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankOperationDao extends JpaRepository<BankOperation, Long> {}
