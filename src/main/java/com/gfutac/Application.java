package com.gfutac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.gfutac.model")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
