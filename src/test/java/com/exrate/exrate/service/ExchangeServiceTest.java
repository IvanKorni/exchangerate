package com.exrate.exrate.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ExchangeServiceTest {

    @Autowired
    ExchangeService exchangeService;

    @Test
    void getExchangeRate() {
        assertTrue(exchangeService.getExchangeRate().getRates().containsKey("RUB"));
    }

    @Test
    void getHistoricalExchangeRate() {
        assertTrue(exchangeService.getHistoricalExchangeRate("2002-02-02").getRates().containsKey("EUR"));
    }
}