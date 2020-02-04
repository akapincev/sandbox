package com.akapincev.feignclient.service;

import com.akapincev.feignclient.client.CustomerClient;
import com.akapincev.feignclient.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerClient customerClient;

    public CustomerDTO findCustomerById(long customerId) {
        return customerClient.findCustomerById(customerId);
    }

    public List<CustomerDTO> findAllCustomers() {
        return customerClient.findAllCustomers();
    }
}
