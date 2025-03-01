package com.repoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class RepooApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepooApplication.class, args);
    }

}
