package com.gri.alex.webcrawler.configuration;

import com.gri.alex.webcrawler.service.WebService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: Alex
 * Date: 05-Aug-18
 */
@Configuration
public class WebConfiguration {

    @Bean
    WebService serviceRegistration(){
        return new WebService();
    }
}
