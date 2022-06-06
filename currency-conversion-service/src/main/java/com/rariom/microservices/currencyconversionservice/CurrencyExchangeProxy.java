package com.rariom.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// this should be an INTERFACE
// we will call the Currency Exchange Microservice
// in Currency Conversion Microservice using
// Currency Conversion Proxy
// the name should be the same as the name you provide in the application.properties of the
// microservice you want to connect "currency-exchange"
//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange") // make the feign client talk to the eureka and pick up the instance of currency exchange and do load balancing between them
public interface CurrencyExchangeProxy {

    // from currency exchange controller
    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);

    }
