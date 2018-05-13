package de.marcusjanke.examples.springcloud.newsservice.controller;

import de.marcusjanke.examples.springcloud.newsservice.model.News;
import de.marcusjanke.examples.springcloud.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("news/")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(path = "breaking", method = RequestMethod.GET, produces = "application/json")
    public News getNews() {
        return newsService.getNews();
    }
}
