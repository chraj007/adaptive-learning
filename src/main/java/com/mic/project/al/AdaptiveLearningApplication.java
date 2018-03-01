package com.mic.project.al;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdaptiveLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdaptiveLearningApplication.class, args);
    }
}
