package com.exrate.exrate.service;

import com.exrate.exrate.model.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rates", url = "${exchange.server}")
public interface ExchangeService {
    @GetMapping(value = "/latest.json?app_id=" + "${exchange.api.id}" + "&base=" + "${exchange.base}",
            consumes= MediaType.APPLICATION_JSON_VALUE)
    Exchange getExchangeRate();

    @GetMapping(
            value = "/historical/" + "{userDate}" + ".json?app_id=" + "${exchange.api.id}" + "&base=" + "${exchange.base}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    Exchange getHistoricalExchangeRate(@PathVariable String userDate);
}
