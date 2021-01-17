package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.CurrentAccount;
import org.springframework.data.repository.CrudRepository;

public interface CurrentAccountDao extends CrudRepository<CurrentAccount, Long> {}
