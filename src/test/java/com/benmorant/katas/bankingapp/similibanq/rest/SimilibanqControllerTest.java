package com.benmorant.katas.bankingapp.similibanq.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class SimilibanqControllerTest {

  @Autowired private SimilibanqController controller;

  @Autowired private MockMvc mockMvc;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void should_return_status_404_and_empty_content_when_uri_is_not_correct()
      throws Exception {
    // Given
    String inputUri = "/rest/similghuyfyibanq-api/publfg/";
    String expectedContent = "";
    String actualContent;
    int actualStatus;
    int expectedStatus = 404;

    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri).contentType(APPLICATION_JSON)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualContent).isEqualTo(expectedContent);
  }

  @Test
  public void should_return_status_200_but_not_corresponding_content_when_id_account_is_other()
      throws Exception {

    // Given
    Long inputIdAccount = 2L;
    String inputUri = "/rest/similibanq-api/public/account/" + inputIdAccount;
    String expectedContent =
        "{\"type\":\"current_account\",\"idAccount\":1,\"balance\":1000.0,\"bankOperations\":[{\"type\":\"withdrawal\",\"idOperation\":1,\"operationDate\":\"2019-06-07T02:00:00\",\"amount\":40.5}]}";
    String actualContent;
    int actualStatus;
    int expectedStatus = 200;

    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri).contentType(APPLICATION_JSON)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualContent).isNotEqualTo(expectedContent);
  }

  @Test
  public void should_return_status_200_and_corresponding_content_when_path_variable_is_1()
      throws Exception {

    // Given
    Long inputIdAccount = 1L;
    String inputUri = "/rest/similibanq-api/public/account/" + inputIdAccount;
    String expectedContent =
        "{\"type\":\"current_account\",\"idAccount\":1,\"balance\":1000.0,\"bankOperations\""
            + ":[{\"type\":\"withdrawal\",\"idOperation\":1,\"operationDate\""
            + ":\"2019-06-07T02:00:00\",\"amount\":40.5}],\"overdraft\":-10.0}";
    String actualContent;
    int actualStatus;
    int expectedStatus = 200;

    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri).contentType(APPLICATION_JSON)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualContent).isEqualTo(expectedContent);
  }

  @Test
  public void should_return_empty_body_when_customer_identifier_is_null() throws Exception {

    // Given
    String inputCustomerIdentifier = null;
    String inputUri =
        "/rest/similibanq-api/public/customer/" + inputCustomerIdentifier + "/accounts";
    int actualStatus;
    int expectedStatus = 200;
    String actualContent;
    // When
    MvcResult mvcResult =
        mockMvc
            .perform(MockMvcRequestBuilders.get(inputUri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();
    Account[] actualAccounts = mapFromJson(actualContent, Account[].class);

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualAccounts).isNotNull();
    assertThat(actualAccounts).isEmpty();
  }

  @Test
  public void should_return_status_404_when_customer_identifier_is_empty() throws Exception {

    // Given
    String inputCustomerIdentifier = "";
    String inputUri =
        "/rest/similibanq-api/public/customer/" + inputCustomerIdentifier + "/accounts";
    int actualStatus;
    int expectedStatus = 404;

    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri).contentType(APPLICATION_JSON)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
  }

  @Test
  public void
      should_return_status_200_but_no_account_information_when_customer_identifier_doesn_t_exist()
          throws Exception {
    // Given
    String inputCustomerIdentifier = "DOESNT*EXIST";
    String inputUri =
        "/rest/similibanq-api/public/customer/" + inputCustomerIdentifier + "/accounts";
    int actualStatus;
    int expectedStatus = 200;
    String actualContent;
    int expectedLength = 0;
    // When
    MvcResult mvcResult =
        mockMvc
            .perform(MockMvcRequestBuilders.get(inputUri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();
    Account[] actualAccounts = mapFromJson(actualContent, Account[].class);

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualAccounts).isNotNull();
    assertThat(actualAccounts.length).isEqualTo(expectedLength);
  }

  @Test
  public void
      should_return_status_200_and_corresponding_account_information_when_customer_identifier_is_A1234567()
          throws Exception {
    // Given
    String inputCustomerIdentifier = "A1234567";
    String inputUri =
        "/rest/similibanq-api/public/customer/" + inputCustomerIdentifier + "/accounts";
    int actualStatus;
    int expectedStatus = 200;
    String actualContent;
    int expectedLength = 2;
    // When
    MvcResult mvcResult =
        mockMvc
            .perform(MockMvcRequestBuilders.get(inputUri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();
    Account[] actualAccounts = mapFromJson(actualContent, Account[].class);

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualAccounts).isNotNull();
    assertThat(actualAccounts).isNotEmpty();
    assertThat(actualAccounts.length).isEqualTo(expectedLength);
  }

  private <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(json, clazz);
  }
}
