package com.benmorant.katas.bankingapp.similibanq.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DiscriminatorValue(value = "savings_account")
@Table
public class SavingsAccount extends Account {

  public SavingsAccount() {}

  public SavingsAccount(double balance, Customer customer) {
    super(balance, customer);
  }
}
