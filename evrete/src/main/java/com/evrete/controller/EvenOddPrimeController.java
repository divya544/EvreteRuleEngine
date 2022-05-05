package com.evrete.controller;

import com.evrete.model.Number;
import com.evrete.service.EvenOddPrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EvenOddPrimeController {

    @Autowired
    private EvenOddPrimeService evenOddPrimeService;


    @GetMapping("/evenOddPrime")
    public String getEvenPrime(@RequestBody Number obj) throws IOException {
        evenOddPrimeService.evenPrime(obj.getNumber());
        return "success";
    }

}
