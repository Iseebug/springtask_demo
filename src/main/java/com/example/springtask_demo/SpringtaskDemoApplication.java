package com.example.springtask_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringtaskDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtaskDemoApplication.class, args);
    }

}
