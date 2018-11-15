package com.redis.normal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 */

@SpringBootApplication
@ServletComponentScan
@MapperScan({"com.redis.normal.mapper","com.redis.normal.generatecode.mapper"})

public class NormalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NormalApplication.class, args);
    }
}
