package com.rariom.microservices.currencyexchangeservice.repository;

import com.rariom.microservices.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository
        extends JpaRepository<CurrencyExchange, Long> {

    /* Query the table by "from" and "to"
            SELECT *
            FROM CURRENCY_EXCHANGE
            WHERE
            CURRENCY_FROM = 'USD'
            AND
            CURRENCY_TO = 'PHP';  */
    CurrencyExchange findByFromAndTo(String from, String to);
}
