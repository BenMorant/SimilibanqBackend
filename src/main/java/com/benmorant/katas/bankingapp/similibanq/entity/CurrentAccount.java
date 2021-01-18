package com.benmorant.katas.bankingapp.similibanq.entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "current_account")
public class CurrentAccount extends Account {

  public CurrentAccount() {}

  public CurrentAccount(
      Long idAccount, double balance, Customer customer, List<BankOperation> bankOperations) {
    super(idAccount, balance, customer, bankOperations);
  }
}
