package com.benmorant.katas.bankingapp.similibanq.entity;

import java.time.LocalDateTime;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@DiscriminatorValue(value = "withdrawal")
@Table
public class Withdrawal extends BankOperation {

  public Withdrawal() {}

  public Withdrawal(LocalDateTime operationDate, double amount, Account account) {
    super(operationDate, amount, account);
  }
}
