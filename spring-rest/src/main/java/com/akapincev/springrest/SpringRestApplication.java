package com.akapincev.springrest;

import com.akapincev.springrest.entity.CustomerEntity;
import com.akapincev.springrest.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDB(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new CustomerEntity("Jack", "Bauer", "Herr"));
            repository.save(new CustomerEntity("Roman", "Benedikt", "Herr"));
            repository.save(new CustomerEntity("Anton", "Schmidt", "Herr"));
        };
    }

}
