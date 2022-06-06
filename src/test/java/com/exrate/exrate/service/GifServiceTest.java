package com.exrate.exrate.service;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
class GifServiceTest {

    @Autowired
    GifService gifService;

    @Test
    void getGif() {
        MatcherAssert.assertThat(gifService.getGif("{$gif.rich}").getData().toString(), CoreMatchers.containsString("https"));
        MatcherAssert.assertThat(gifService.getGif("{$gif.broke}").getData().toString(), CoreMatchers.containsString("https"));

    }
}