package com.benmorant.katas.bankingapp.similibanq.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping(path = "/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping(path = "/hello-name")
  public String helloWithParameters(@RequestParam(value = "name", required = false) String name) {
    return "Hello " + name;
  }
}
