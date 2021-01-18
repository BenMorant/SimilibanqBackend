package com.benmorant.katas.bankingapp.similibanq.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DiscriminatorValue(value = "current_account")
@Table
public class CurrentAccount extends Account {

  public CurrentAccount() {}

  public CurrentAccount(double balance, Customer customer) {
    super(balance, customer);
  }
}
