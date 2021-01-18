package com.benmorant.katas.bankingapp.similibanq.entity;

import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DiscriminatorValue(value = "deposit")
@Table
public class Deposit extends BankOperation {

  public Deposit() {}

  public Deposit(LocalDateTime operationDate, double amount, Account account) {
    super(operationDate, amount, account);
  }
}
