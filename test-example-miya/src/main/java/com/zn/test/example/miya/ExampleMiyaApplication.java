package com.zn.test.example.miya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ExampleMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleMiyaApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ExampleMiyaApplication.class.getName());


    @RequestMapping("/hi")
    public String home(){
        LOG.info("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        LOG.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}