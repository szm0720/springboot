package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@SpringBootApplication
@RestController
public class RabbitMqApplication {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String nihao() {
        return "adf";
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }
}
