package com.exrate.exrate.service;

import com.exrate.exrate.util.Util;
import com.exrate.exrate.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdapterImpl implements Adapter {
    @Autowired
    public ExchangeService exchangeService;

    @Autowired
    public GifService gifService;

    public Gif getGif(String currency) {

        int result = Util.comparisonExchangeRates(currency, exchangeService);

        if (result == 1) {
            return gifService.getGif("${gif.rich}");
        } else if (result == -1) {
            return gifService.getGif("${gif.broke}");
        } else {
            return Util.FakeGif();
        }
    }

}
