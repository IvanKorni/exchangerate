package com.exrate.exrate.service;

import com.exrate.exrate.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "gif", url = "${gif.server}")
public interface GifService {
    @GetMapping( value = "?api_key=" + "${gif.api.id}" + "&tag=" + "{value}" + "&rating=g",
            consumes= MediaType.APPLICATION_JSON_VALUE)
    Gif getGif(@PathVariable() String value);
}
