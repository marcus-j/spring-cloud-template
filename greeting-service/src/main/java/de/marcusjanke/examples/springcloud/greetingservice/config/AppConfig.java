package de.marcusjanke.examples.springcloud.greetingservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        //create Ribbon-enabled RestTemplate
        return new RestTemplate();
    }
}
