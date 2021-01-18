package com.benmorant.katas.bankingapp.similibanq.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class SimilibanqServiceTest {

  @Autowired private SimilibanqService similibanqService;

  @Autowired private DataSource dataSource;
  @Autowired private JdbcTemplate jdbcTemplate;
  @Autowired private EntityManager entityManager;

  @Test
  public void contextLoads() {
    assertThat(dataSource).isNotNull();
    assertThat(jdbcTemplate).isNotNull();
    assertThat(entityManager).isNotNull();
    assertThat(similibanqService).isNotNull();
  }

  @Test
  public void should_return_1L_when_id_equals_1L() {
    // Given
    Long inputId = 1L;
    Account actualAccount;
    Long expectedAccountId = 1L;

    // When
    actualAccount = similibanqService.getAccountById(inputId);

    // Then
    assertThat(actualAccount.getIdAccount()).isEqualTo(expectedAccountId);
  }

  @Test
  public void should_return_empty_list_when_customer_identifier_equals_empty() {
    // Given
    String inputIdentifier = "";
    List<Account> actualAccounts;
    List<Long> expectedAccountsId = new ArrayList<>();
    List<Long> actualAccountsId = new ArrayList<>();

    // When
    actualAccounts = similibanqService.getAccountsByCustomerIdentifier(inputIdentifier);
    for (Account actualAccount : actualAccounts) {
      actualAccountsId.add(actualAccount.getIdAccount());
    }

    // Then
    assertThat(actualAccountsId).isEqualTo(expectedAccountsId);
  }

  @Test
  public void should_return_empty_list_when_customer_identifier_doesn_t_exist() {
    // Given
    String inputIdentifier = "#4(X32";
    List<Account> actualAccounts;
    List<Long> expectedAccountsId = new ArrayList<>();
    List<Long> actualAccountsId = new ArrayList<>();

    // When
    actualAccounts = similibanqService.getAccountsByCustomerIdentifier(inputIdentifier);
    for (Account actualAccount : actualAccounts) {
      actualAccountsId.add(actualAccount.getIdAccount());
    }

    // Then
    assertThat(actualAccountsId).isEqualTo(expectedAccountsId);
  }

  @Test
  public void should_return_1L_and_2L_when_customer_identifier_equals_A1234567() {
    // Given
    String inputIdentifier = "A1234567";
    List<Account> actualAccounts;
    List<Long> expectedAccountsId = new ArrayList<>(Arrays.asList(1L, 2L));
    List<Long> actualAccountsId = new ArrayList<>();

    // When
    actualAccounts = similibanqService.getAccountsByCustomerIdentifier(inputIdentifier);
    for (Account actualAccount : actualAccounts) {
      actualAccountsId.add(actualAccount.getIdAccount());
    }

    // Then
    assertThat(actualAccountsId).isEqualTo(expectedAccountsId);
  }
}
