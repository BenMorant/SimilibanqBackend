package com.benmorant.katas.bankingapp.similibanq.entity;

import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "deposit")
public class Deposit extends BankOperation {

  public Deposit() {}

  public Deposit(Long idOperation, LocalDateTime operationDate, double amount, Account account) {
    super(idOperation, operationDate, amount, account);
  }
}
