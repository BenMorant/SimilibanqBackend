package com.benmorant.katas.bankingapp.similibanq.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

  @Autowired private HelloController controller;

  @Autowired private MockMvc mockMvc;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void should_return_Hello_when_accessing_hello() {
    // Given
    String inputUrl = "/hello";
    String expectedContent = "Hello";
    //When
    try {
      mockMvc.perform(get(inputUrl))
          //Then
          .andExpect(status().isOk())
          .andExpect(content().string(expectedContent));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void should_return_Hello_when_accessing_hello_name_without_params() {
    // Given
    String inputUrl = "/hello-name?name=";
    String expectedContent = "Hello ";
    // When
    try {
      mockMvc
          .perform(get(inputUrl))
          // Then
          .andExpect(status().isOk())
          .andExpect(content().string(expectedContent));
    } catch (Exception e) {
      e.printStackTrace();
    }
}

  @Test
  public void should_return_Hello_ben_when_accessing_hello_name_with_param_ben() {
    // Given
    String inputParam = "ben";
    String inputUrl = "/hello-name?name="+ inputParam;
    String expectedContent = "Hello "+inputParam;
    // When
    try {
      mockMvc
          .perform(get(inputUrl))
          // Then
          .andExpect(status().isOk())
          .andExpect(content().string(expectedContent));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
