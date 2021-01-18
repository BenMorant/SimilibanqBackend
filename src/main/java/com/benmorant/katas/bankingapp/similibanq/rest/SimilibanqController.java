package com.benmorant.katas.bankingapp.similibanq.rest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") //authorises everyone in dev phase
@RequestMapping(value = "/rest/similibanq-api", headers = "Accept=application/json")
public class SimilibanqController {

}
