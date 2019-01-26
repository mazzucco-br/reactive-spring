package com.mazzucco.reactivespring.msusuarios.api.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mazzucco.reactivespring.msusuarios.client.msTwo.IMicroserviceTwoClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("usuarios")
class SearchUsuariosRest {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SearchUsuariosRest.class);

    //@Autowired
    //private DiscoveryClient discoveryClient;

    @Autowired
    private IMicroserviceTwoClient microserviceTwoClient;

    @RequestMapping(value="search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @HystrixCommand
    public ResponseOne search() {
        // simula tempo de processamento
        try {
            Thread.sleep((int) (Math.random() * 50) + 10);
        } catch (InterruptedException e) {
        }

        /* Falha aleatóriamente  */
        if (Math.random() > 0.99) {
            throw new RuntimeException("Random failure");
        }
        
        //ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
        ResponseOne response = new ResponseOne();
        response.setHost("localInstance.getHost()");
        response.setPort(0);
        response.setServiceId("localInstance.getServiceId()");
        // Call microserviceTwo.testCallTwo()
        // response.setResponseTwo(microserviceTwoClient.testCallTwo());
        response.setResult("This is microservice ONE response");
        LOGGER.info("Microservice ONE call");
        return response;
    }
}
