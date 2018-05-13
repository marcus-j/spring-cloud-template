package de.marcusjanke.examples.springcloud.greetingservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import de.marcusjanke.examples.springcloud.greetingservice.model.News;

import java.util.Random;

@Component
public class NewsServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    //Enable Hystrix CircuitBreaker with Fallback and Bulkhead with own thread pool
    @HystrixCommand(fallbackMethod = "getDefaultNews",
            threadPoolKey = "newsThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public News getNews() {
        if (new Random().nextBoolean()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ResponseEntity<News> newsEntity = restTemplate.exchange("http://newsservice/news/breaking/", HttpMethod.GET, null, News.class);
        return newsEntity.getBody();
    }

    //Enable Fallback
    public News getDefaultNews() {
        return new News("No News");
    }
}
