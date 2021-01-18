package com.benmorant.katas.bankingapp.similibanq.service;

import com.benmorant.katas.bankingapp.similibanq.dao.AccountDao;
import com.benmorant.katas.bankingapp.similibanq.dao.CustomerDao;
import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import com.benmorant.katas.bankingapp.similibanq.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimilibanqServiceImpl implements SimilibanqService {

  @Autowired private AccountDao accountDao;

  @Autowired private CustomerDao customerDao;

  @Override
  public Account getAccountById(Long idAccount) {
    return accountDao.findById(idAccount).get();
  }

  @Override
  public List<Account> getAccountsByCustomerIdentifier(String customerIdentifier) {
    Customer customer = customerDao.findByCustomerIdentifier(customerIdentifier);
    return accountDao.findByCustomer(customer);
  }
}
