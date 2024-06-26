package com.example.gestorancianato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GestorAncianatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorAncianatoApplication.class, args);
    }

}
