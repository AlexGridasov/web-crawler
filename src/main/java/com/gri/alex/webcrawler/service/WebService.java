package com.gri.alex.webcrawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * User: Alex
 * Date: 05-Aug-18
 */
@Service
public class WebService implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        getData("https://novostroyki.lun.ua/жк-галактика-киев");
    }

    public String getData(String address) {
        Document doc = null;
        try {
            doc = Jsoup.connect(address).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(doc);

        return doc.html();
    }

}
