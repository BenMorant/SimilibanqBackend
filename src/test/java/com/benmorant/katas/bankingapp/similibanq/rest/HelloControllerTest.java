package com.benmorant.katas.bankingapp.similibanq.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class HelloControllerTest {

  @Autowired private HelloController controller;

  @Autowired private MockMvc mockMvc;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void should_return_Hello_when_accessing_hello() throws Exception {
    // Given
    String inputUri = "/hello";
    String expectedContent = "Hello";
    String actualContent;
    int actualStatus;
    int expectedStatus = 200;

    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualContent).isEqualTo(expectedContent);
  }

  @Test
  public void should_return_Hello_when_accessing_hello_name_without_params() throws Exception {
    // Given
    String inputUri = "/hello-name?name=";
    String expectedContent = "Hello ";
    String actualContent;
    int actualStatus;
    int expectedStatus = 200;
    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualContent).isEqualTo(expectedContent);
  }

  @Test
  public void should_return_Hello_ben_when_accessing_hello_name_with_param_ben() throws Exception {
    // Given
    String inputParam = "ben";
    String inputUri = "/hello-name?name=" + inputParam;
    String expectedContent = "Hello " + inputParam;
    String actualContent;
    int actualStatus;
    int expectedStatus = 200;
    // When
    MvcResult mvcResult = mockMvc.perform(get(inputUri)).andReturn();
    actualStatus = mvcResult.getResponse().getStatus();
    actualContent = mvcResult.getResponse().getContentAsString();

    // Then
    assertThat(actualStatus).isEqualTo(expectedStatus);
    assertThat(actualContent).isEqualTo(expectedContent);
  }
}
