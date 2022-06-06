package com.exrate.exrate.util;

import com.exrate.exrate.model.Exchange;
import com.exrate.exrate.service.ExchangeService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    ExchangeService exchangeService = new ExchangeService() {
        final Map<String, Double> mapOne = new HashMap<>();
        final Map<String, Double> mapTwo = new HashMap<>();

        @Override
        public Exchange getExchangeRate() {
            mapOne.put("RUB", 30.0);
            return new Exchange(mapOne);
        }

        @Override
        public Exchange getHistoricalExchangeRate(String userDate) {
            mapTwo.put("RUB", 31.0);
            return new Exchange(mapTwo);
        }
    };

    @Test
    void comparisonExchangeRates() {
        assertEquals(Util.comparisonExchangeRates("RUB", exchangeService), -1);
    }
}