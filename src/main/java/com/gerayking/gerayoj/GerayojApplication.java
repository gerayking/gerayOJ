package com.gerayking.gerayoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gerayking.gerayoj.mapper")
public class GerayojApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerayojApplication.class, args);
    }

}
