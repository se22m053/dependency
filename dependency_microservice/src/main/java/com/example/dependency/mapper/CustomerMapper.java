package com.example.dependency.mapper;

import com.example.dependency.DTO.CustomerDTO;
import com.example.dependency.entity.Customer;

public interface CustomerMapper {

    CustomerDTO entityToDto(Customer customer);

    Customer dtoToEntity(CustomerDTO dto);
}
