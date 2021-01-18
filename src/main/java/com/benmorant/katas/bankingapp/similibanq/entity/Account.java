package com.benmorant.katas.bankingapp.similibanq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
  @Type(value = CurrentAccount.class, name = "current_account"),
  @Type(value = SavingsAccount.class, name = "savings_account")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
@DiscriminatorValue("Account")
public abstract class Account implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_account")
  private Long idAccount;

  @Column(name = "balance")
  private double balance;

  @ManyToOne
  @JoinColumn(name = "id_customer")
  @JsonIgnore
  private Customer customer;

  @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
  private List<BankOperation> bankOperations;

  protected Account() {}

  protected Account(
      Long idAccount, double balance, Customer customer, List<BankOperation> bankOperations) {
    this.idAccount = idAccount;
    this.balance = balance;
    this.customer = customer;
    this.bankOperations = bankOperations;
  }

  public Long getIdAccount() {
    return idAccount;
  }

  public void setIdAccount(Long idAccount) {
    this.idAccount = idAccount;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<BankOperation> getBankOperations() {
    return bankOperations;
  }

  public void setBankOperations(List<BankOperation> bankOperations) {
    this.bankOperations = bankOperations;
  }
}
