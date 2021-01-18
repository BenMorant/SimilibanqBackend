package com.benmorant.katas.bankingapp.similibanq.rest;

import com.benmorant.katas.bankingapp.similibanq.entity.Account;
import com.benmorant.katas.bankingapp.similibanq.exception.MyEntityNotFoundException;
import com.benmorant.katas.bankingapp.similibanq.service.SimilibanqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*") // authorises everyone in dev phase
@RequestMapping(value = "/rest/similibanq-api", headers = "Accept=application/json")
public class SimilibanqController {

  @Autowired private SimilibanqService similibanqService;

  // http://localhost:8060/similibanq-backend/rest/similibanq-api/public/account/1
  @GetMapping(value = "/public/account/{idAccount}")
  Account getAccountById(@PathVariable(name = "idAccount") Long idAccount)
      throws MyEntityNotFoundException {
    Account account = similibanqService.getAccountById(idAccount);
    if (account == null) throw new MyEntityNotFoundException("no account with ID " + idAccount);
    else return account;
  }
}
