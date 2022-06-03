package com.rariom.microservices.currencyconversionservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/currency-conversion")
public class CurrencyConversionController {

    @GetMapping(path = "/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity){

        // call the currency exchange microservice using RestTemplate
        new RestTemplate()
                .getForEntity()
        return new CurrencyConversion(
                1001L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, "");
    }
}
