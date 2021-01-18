package com.benmorant.katas.bankingapp.similibanq.dao;

import com.benmorant.katas.bankingapp.similibanq.entity.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountDao extends JpaRepository<CurrentAccount, Long> {}
