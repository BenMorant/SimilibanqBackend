package com.benmorant.katas.bankingapp.similibanq.entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "savings_account")
public class SavingsAccount extends Account {

  public SavingsAccount() {}

  public SavingsAccount(
      Integer idAccount, double balance, Customer customer, List<BankOperation> bankOperations) {
    super(idAccount, balance, customer, bankOperations);
  }
}
