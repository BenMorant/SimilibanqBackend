package com.benmorant.katas.bankingapp.similibanq.service;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import java.util.List;

public interface SimilibanqService {

  Account getAccountById(Long idAccount);

  List<Account> getAccountsByCustomerIdentifier(String customerIdentifier);
}
