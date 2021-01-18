package com.benmorant.katas.bankingapp.similibanq.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
  public void should_return_status_200_but_not_corresponding_content_when_path_variable_is_2()
      throws Exception {

    // Given
    String inputUri = "/rest/similibanq-api/public/account/2";
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
    String inputUri = "/rest/similibanq-api/public/account/1";
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
    assertThat(actualContent).isEqualTo(expectedContent);
  }
}
