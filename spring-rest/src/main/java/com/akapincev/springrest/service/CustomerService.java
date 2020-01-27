package com.akapincev.springrest.service;

import com.akapincev.springrest.entity.CustomerEntity;
import com.akapincev.springrest.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerEntity findCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }

    public List<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }
}
