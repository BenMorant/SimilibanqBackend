package com.benmorant.katas.bankingapp.similibanq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimilibanqApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimilibanqApplication.class, args);
    System.out.println("http://localhost:8060/similibanq-backend/index.html");
  }
}
