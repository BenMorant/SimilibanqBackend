package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.BankOperation;
import org.springframework.data.repository.CrudRepository;

public interface BankOperationDao extends CrudRepository<BankOperation, Long> {}
