package com.example.sokdak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SokdakApplication {

    public static void main(String[] args) {
        SpringApplication.run(SokdakApplication.class, args);
    }

}
