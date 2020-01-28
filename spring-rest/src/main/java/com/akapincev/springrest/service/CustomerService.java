package com.akapincev.springrest.service;

import com.akapincev.springrest.dto.CustomerDTO;
import com.akapincev.springrest.entity.CustomerEntity;
import com.akapincev.springrest.repository.CustomerRepository;
import com.akapincev.springrest.utils.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper mapper;

    public CustomerDTO findCustomerById(long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId);
        return mapper.toCustomerDTO(customerEntity);
    }

    public List<CustomerEntity> findAllCustomerEntities() {
        return customerRepository.findAll();
    }

    public List<CustomerDTO> findAllCustomers() {
        return mapper.toCustomerDTOList(customerRepository.findAll());
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerRepository.save(mapper.toCustomerEntity(customerDTO));
        return mapper.toCustomerDTO(customerEntity);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        CustomerEntity customerEntity = mapper.toCustomerEntity(customerDTO);
        customerEntity.setId(id);
        return mapper.toCustomerDTO(customerRepository.save(customerEntity));
    }
}
