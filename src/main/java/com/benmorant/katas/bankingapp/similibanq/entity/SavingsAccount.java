package com.benmorant.katas.bankingapp.similibanq.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DiscriminatorValue(value = "savings_account")
@Table
public class SavingsAccount extends Account {

  private double interestRate;

  public SavingsAccount() {}

  public SavingsAccount(double balance, Customer customer, double interestRate) {
    super(balance, customer);
    this.interestRate = interestRate;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
}
