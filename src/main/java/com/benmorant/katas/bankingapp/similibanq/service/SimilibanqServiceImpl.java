package com.benmorant.katas.bankingapp.similibanq.service;

import com.benmorant.katas.bankingapp.similibanq.dao.AccountDao;
import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimilibanqServiceImpl implements SimilibanqService {

  @Autowired private AccountDao accountDao;

  @Override
  public Account getAccountById(Long idAccount) {
    return accountDao.findById(idAccount).get();
  }
}
