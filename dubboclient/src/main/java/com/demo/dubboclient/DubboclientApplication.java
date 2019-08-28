package com.demo.dubboclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo2.xml")
public class DubboclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboclientApplication.class, args);
    }

}
