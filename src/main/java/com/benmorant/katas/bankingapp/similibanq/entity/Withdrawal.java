package com.benmorant.katas.bankingapp.similibanq.entity;

import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "withdrawal")
public class Withdrawal extends BankOperation {

  public Withdrawal() {}

  public Withdrawal(Long idOperation, LocalDateTime operationDate, double amount, Account account) {
    super(idOperation, operationDate, amount, account);
  }
}
