package com.benmorant.katas.bankingapp.similibanq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
  @Type(value = Deposit.class, name = "deposit"),
  @Type(value = Withdrawal.class, name = "withdrawal")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "operation_type")
@DiscriminatorValue("BankOperation")
public abstract class BankOperation implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_operation")
  private Long idOperation;

  @Column(name = "operation_date")
  private LocalDateTime operationDate;

  @Column(name = "operation_amount")
  private double amount;

  @ManyToOne
  @JoinColumn(name = "id_account")
  @JsonIgnore
  private Account account;

  protected BankOperation() {}

  protected BankOperation(
      Long idOperation, LocalDateTime operationDate, double amount, Account account) {
    this.idOperation = idOperation;
    this.operationDate = operationDate;
    this.amount = amount;
    this.account = account;
  }

  public Long getIdOperation() {
    return idOperation;
  }

  public void setIdOperation(Long idOperation) {
    this.idOperation = idOperation;
  }

  public LocalDateTime getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(LocalDateTime operationDate) {
    this.operationDate = operationDate;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
