package com.benmorant.katas.bankingapp.similibanq.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DiscriminatorValue(value = "current_account")
@Table
public class CurrentAccount extends Account {

  private double overdraft;

  public CurrentAccount() {}

  public CurrentAccount(double balance, Customer customer, double overdraft) {
    super(balance, customer);
    this.overdraft = overdraft;
  }

  public double getOverdraft() {
    return overdraft;
  }

  public void setOverdraft(double overdraft) {
    this.overdraft = overdraft;
  }
}
