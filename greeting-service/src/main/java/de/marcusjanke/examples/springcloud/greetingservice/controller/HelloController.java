package de.marcusjanke.examples.springcloud.greetingservice.controller;

import de.marcusjanke.examples.springcloud.greetingservice.services.NewsServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${service.hello}")
    private String helloName;
    @Autowired
    private NewsServiceClient newsServiceClient;

    @RequestMapping(path = "hello", method = RequestMethod.GET)
    public String hello() {
        return String.format("Hello %s: %s", helloName, newsServiceClient.getNews().getText());
    }
}
