package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalDao extends CrudRepository<Withdrawal, Long> {}
