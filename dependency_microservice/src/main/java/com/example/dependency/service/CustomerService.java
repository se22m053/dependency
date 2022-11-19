package com.example.dependency.service;

import com.example.dependency.DTO.CustomerDTO;
import com.example.dependency.DTO.CustomerNameAndBalanceDTO;
import com.example.dependency.entity.Customer;
import com.example.dependency.entity.Product;
import com.example.dependency.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {

        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> retrieveAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new LinkedList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setName(customer.getName());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setStatus(customer.getStatus());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    public List<CustomerNameAndBalanceDTO> retrieveAllCustomerNamesAndBalances() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerNameAndBalanceDTO> customerNameAndBalanceDTOS = new LinkedList<>();
        int aggregatedBalance = 0;
        for (Customer customer : customers) {
            CustomerNameAndBalanceDTO customerDTO = new CustomerNameAndBalanceDTO();
            customerDTO.setName(customer.getName());
            for (Product product : customer.getProducts()) {
                aggregatedBalance += product.getBalance();
            }
            customerDTO.setAggregatedBalance(aggregatedBalance);
            customerNameAndBalanceDTOS.add(customerDTO);
        }
        return customerNameAndBalanceDTOS;
    }
}