package com.mazzucco.reactivespring.msassinaturas.api.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("assinaturas")
class SearchAssinaturasRest {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SearchAssinaturasRest.class);

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value="search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @HystrixCommand
    public String search() {
        // simula tempo de processamento
        try {
            Thread.sleep((int) (Math.random() * 50) + 10);
        } catch (InterruptedException e) {
        }

        /* Falha aleatóriamente  */
        if (Math.random() > 0.99) {
            throw new RuntimeException("Random failure");
        }
        
        return "sucesso";
    }
}
