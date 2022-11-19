package com.example.dependency.configuration;

import com.example.dependency.entity.Customer;
import com.example.dependency.entity.Product;
import com.example.dependency.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.*;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.deleteAll();
            Set<Product> products = new HashSet<>();
            Product product = new Product("Bitcoin", 100, "y", "x");
            products.add(product);
            Customer manuel = new Customer("Manuel", "ManuelAdress", LocalDate.now(), "manuels-email", "manuels-status", products);

            customerRepository.save(manuel);
        };
    }
}