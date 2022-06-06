package com.exrate.exrate.util;

import com.exrate.exrate.exception_handling.NotFoundException;
import com.exrate.exrate.model.Gif;
import com.exrate.exrate.model.GifData;
import com.exrate.exrate.service.ExchangeService;

import java.time.LocalDate;


public class Util {
    public static int comparisonExchangeRates(String currency, ExchangeService exchangeService) {
        checkNotFoundCurrency(currency, exchangeService);

        Double currencyRate = exchangeService.getExchangeRate().getRates().get(currency.toUpperCase());
        Double yesterdayRate = exchangeService.getHistoricalExchangeRate(LocalDate.now().minusDays(1).toString()).getRates().get(currency.toUpperCase());

        return Double.compare(currencyRate, yesterdayRate);

    }

    public static void checkNotFoundCurrency(String currency, ExchangeService exchangeService) {
        if (exchangeService.getExchangeRate().getRates().get(currency.toUpperCase()) == null) {
            throw new NotFoundException("Not found currency " + currency);
        }
    }

    public static Gif FakeGif() {
        return new Gif(new GifData("Rate is equal to yesterday"));
    }
}
