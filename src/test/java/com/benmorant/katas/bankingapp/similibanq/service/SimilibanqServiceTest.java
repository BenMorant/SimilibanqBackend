package com.benmorant.katas.bankingapp.similibanq.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;

import com.benmorant.katas.bankingapp.similibanq.dao.AccountDao;
import com.benmorant.katas.bankingapp.similibanq.dao.BankOperationDao;
import com.benmorant.katas.bankingapp.similibanq.dao.CustomerDao;
import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import com.benmorant.katas.bankingapp.similibanq.entity.CurrentAccount;
import com.benmorant.katas.bankingapp.similibanq.entity.Customer;
import com.benmorant.katas.bankingapp.similibanq.entity.SavingsAccount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimilibanqServiceTest {

  private SimilibanqService similibanqService;

  @Mock private AccountDao accountDao;
  @Mock private BankOperationDao bankOperationDao;

  @Mock private CustomerDao customerDao;

  @BeforeEach
  public void initEach() {
    Customer paul = new Customer("Paul", "A1234567");
    Account account1 = new CurrentAccount(1000.0, paul, 0.0);
    Account account2 = new SavingsAccount(500.0, paul, 0.0);
    List<Account> paulAccounts = new ArrayList<>();
    paulAccounts.add(account1);
    paulAccounts.add(account2);
    similibanqService = new SimilibanqServiceImpl(accountDao, customerDao, bankOperationDao);
    Mockito.lenient()
        .when(accountDao.findById(any(Long.class)))
        .thenReturn(java.util.Optional.of(account1));
    Mockito.lenient().when(accountDao.findByCustomer(any(Customer.class))).thenReturn(paulAccounts);
    Mockito.lenient()
        .when(customerDao.findByCustomerIdentifier(any(String.class)))
        .thenReturn(paul);
  }

  @Test
  public void should_return_paul_when_id_equals_1L() {
    // Given
    Long inputId = 1L;
    Account actualAccount;
    String expectedName = "paul";

    // When
    actualAccount = similibanqService.getAccountById(inputId);

    // Then
    assertThat(actualAccount.getCustomer().getName()).isEqualToIgnoringCase(expectedName);
  }

  @Test
  public void should_return_1L_and_2L_when_customer_identifier_equals_A1234567() {
    // Given
    String inputIdentifier = "A1234567";
    List<Account> actualAccounts;
    List<Double> expectedAccountsBalances = new ArrayList<>(Arrays.asList(1000.0, 500.0));
    List<Double> actualAccountsBalances = new ArrayList<>();

    // When
    actualAccounts = similibanqService.getAccountsByCustomerIdentifier(inputIdentifier);
    for (Account actualAccount : actualAccounts) {
      actualAccountsBalances.add(actualAccount.getBalance());
    }

    // Then
    assertThat(actualAccountsBalances).isEqualTo(expectedAccountsBalances);
  }

  @Test
  public void actual_balance_should_be_same_as_expected_balance() {
    // Given
    Long inputAccountId = 1L;
    double expectedBalance = 1000.0;
    similibanqService.getAccountById(inputAccountId).setBalance(expectedBalance);
    // When
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    // Then
    assertThat(actualBalance).isEqualTo(expectedBalance);
  }

  @Test
  public void should_add_0_to_balance_when_addToAccount_0() {
    // Given
    Long inputAccountId = 1L;
    double inputamount = 0.0;
    double expectedBalance = 1000.0;

    // When
    similibanqService.addToAccount(inputAccountId, inputamount);
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    // Then
    assertThat(actualBalance).isEqualTo(expectedBalance);
  }

  @Test
  public void should_not_add_0_to_balance_when_addToAccount_10() {
    // Given
    Long inputAccountId = 1L;
    double inputamount = 10.0;
    double expectedBalance = 1000.0;

    // When
    similibanqService.addToAccount(inputAccountId, inputamount);
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    // Then
    assertThat(actualBalance).isNotEqualTo(expectedBalance);
  }

  @Test
  public void should_add_10_to_balance_when_addToAccount_10() {
    // Given
    Long inputAccountId = 1L;
    double inputamount = 10.0;
    double expectedBalance = 1000.0 + inputamount;

    // When
    similibanqService.addToAccount(inputAccountId, inputamount);
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    // Then
    assertThat(actualBalance).isEqualTo(expectedBalance);
  }

  @Test
  public void should_remove_0_to_balance_when_RemoveFromAccount_0() {
    // Given
    Long inputAccountId = 1L;
    double inputamount = 0.0;
    double expectedBalance = 1000.0;

    // When
    similibanqService.removeFromAccount(inputAccountId, inputamount);
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    // Then
    assertThat(actualBalance).isEqualTo(expectedBalance);
  }

  @Test
  public void should_not_remove_0_to_balance_when_removeFromAccount_10() {
    // Given
    Long inputAccountId = 1L;
    double inputamount = 10.0;
    double expectedBalance = 1000.0;

    // When
    similibanqService.removeFromAccount(inputAccountId, inputamount);
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    // Then
    assertThat(actualBalance).isNotEqualTo(expectedBalance);
  }

  @Test
  public void should_remove_10_to_balance_when_removeFromAccount_10() {
    // Given
    Long inputAccountId = 1L;
    double inputamount = 10.0;
    double expectedBalance = 1000.0 - inputamount;

    // When
    similibanqService.removeFromAccount(inputAccountId, inputamount);
    double actualBalance = similibanqService.getAccountById(inputAccountId).getBalance();
    System.out.println("actualBalance = " + actualBalance);
    // Then
    assertThat(actualBalance).isEqualTo(expectedBalance);
  }
}
