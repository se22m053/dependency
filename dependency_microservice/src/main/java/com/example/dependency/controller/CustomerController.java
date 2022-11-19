package com.example.dependency.controller;

import com.example.dependency.DTO.CustomerDTO;
import com.example.dependency.DTO.CustomerNameAndBalanceDTO;
import com.example.dependency.entity.Customer;
import com.example.dependency.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomerController {

    Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customer")
    public List<CustomerDTO> retrieveAllCustomers() {
        LOGGER.info("Retrieve all customers name, email and status!");
        return customerService.retrieveAllCustomers();
    }

    @GetMapping("/customer-balances")
    public List<CustomerNameAndBalanceDTO> retrieveAllCustomerNamesAndBalances() {
        LOGGER.info("Customers with Name and Balance are getting retrieved!");
        return customerService.retrieveAllCustomerNamesAndBalances();
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        LOGGER.info("Customer " + customer.toString() + "will be added!");
        customerService.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        LOGGER.info("Customer with id " + id + "will be deleted!");
        customerService.delete(id);
    }
}
