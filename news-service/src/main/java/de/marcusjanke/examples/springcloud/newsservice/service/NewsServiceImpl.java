package de.marcusjanke.examples.springcloud.newsservice.service;

import de.marcusjanke.examples.springcloud.newsservice.model.News;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    public News getNews() {
        return new News("Winter is coming!");
    }
}
