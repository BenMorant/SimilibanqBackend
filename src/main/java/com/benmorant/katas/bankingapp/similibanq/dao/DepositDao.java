package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface DepositDao extends CrudRepository<Deposit, Long> {}
