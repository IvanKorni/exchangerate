package com.exrate.exrate.controller;

import com.exrate.exrate.model.Gif;
import com.exrate.exrate.service.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {
    @Autowired
    private Adapter adapter;

    @GetMapping("/gif/{currency}")
    public Gif getExchange(@PathVariable() String currency) {
        return adapter.getGif(currency);
    }
}
