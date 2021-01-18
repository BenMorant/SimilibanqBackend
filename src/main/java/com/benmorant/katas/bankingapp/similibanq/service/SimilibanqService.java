package com.benmorant.katas.bankingapp.similibanq.service;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;

public interface SimilibanqService {

  Account getAccountById(Long idAccount);
}
