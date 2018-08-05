package com.gri.alex.webcrawler.service;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

/**
 * User: Alex
 * Date: 05-Aug-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebServiceTest {

    @MockBean
    private WebService webService;

    String mockDoc = "";

    @BeforeAll
    void setup() throws IOException {
        File file = new ClassPathResource("zhk-galaktika-kiev.html").getFile();
        mockDoc = String.valueOf(Jsoup.parse(file, "UTF-8", ""));
    }

    @Test
    void getData() {
        String address = "https://novostroyki.lun.ua/жк-галактика-киев";
        Mockito.when(webService.getData(address))
                .thenReturn(mockDoc);

        webService.getData(address);
    }
}
