package com.benmorant.katas.bankingapp.similibanq.service;

import com.benmorant.katas.bankingapp.similibanq.dao.AccountDao;
import com.benmorant.katas.bankingapp.similibanq.dao.BankOperationDao;
import com.benmorant.katas.bankingapp.similibanq.dao.CustomerDao;
import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import com.benmorant.katas.bankingapp.similibanq.entity.BankOperation;
import com.benmorant.katas.bankingapp.similibanq.entity.Customer;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimilibanqServiceImpl implements SimilibanqService {

  @Autowired private AccountDao accountDao;

  @Autowired private CustomerDao customerDao;

  @Autowired private BankOperationDao bankOperationDao;

  public SimilibanqServiceImpl() {}

  public SimilibanqServiceImpl(
      AccountDao accountDao, CustomerDao customerDao, BankOperationDao bankOperationDao) {
    this.accountDao = accountDao;
    this.customerDao = customerDao;
    this.bankOperationDao = bankOperationDao;
  }

  @Override
  public Account getAccountById(Long idAccount) {
    return accountDao.findById(idAccount).get();
  }

  @Override
  public List<Account> getAccountsByCustomerIdentifier(String customerIdentifier) {
    Customer customer = customerDao.findByCustomerIdentifier(customerIdentifier);
    return accountDao.findByCustomer(customer);
  }

  @Override
  public void addToAccount(Long idAccount, double amount) {
    Account currentAccount = getAccountById(idAccount);
    BankOperation deposit =
        new BankOperation(LocalDateTime.now(), amount, currentAccount, "deposit");
    bankOperationDao.save(deposit);
    currentAccount.setBalance(currentAccount.getBalance() + amount);
    accountDao.save(currentAccount);
  }

  @Override
  public void removeFromAccount(Long idAccount, double amount) {
    Account currentAccount = getAccountById(idAccount);
    BankOperation withdrawal =
        new BankOperation(LocalDateTime.now(), amount, currentAccount, "withdrawal");
    bankOperationDao.save(withdrawal);
    currentAccount.setBalance(currentAccount.getBalance() - amount);
    accountDao.save(currentAccount);
  }

  @Override
  public void transferAmount(Long idOriginAccount, Long idDestinationAccount, double amount) {
    removeFromAccount(idOriginAccount, amount);
    addToAccount(idDestinationAccount, amount);
  }
}
