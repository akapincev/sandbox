package com.akapincev.springrest.web;

import com.akapincev.springrest.dto.CustomerDTO;
import com.akapincev.springrest.entity.CustomerEntity;
import com.akapincev.springrest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDTO findCustomerById(@PathVariable long id) {
        log.info("Receive GET-REQUEST on endpoint /customer/{}", id);
        return customerService.findCustomerById(id);
    }

    @GetMapping("/entities")
    public List<CustomerEntity> findAllEntities() {
        log.info("Receive GET-REQUEST on endpoint /customer/");
        return customerService.findAllCustomerEntities();
    }

    @GetMapping("")
    public List<CustomerDTO> findAllCustomers() {
        log.info("Receive GET-REQUEST on endpoint /customer/");
        return customerService.findAllCustomers();
    }

    @PostMapping("")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        log.info("Receive CREATE-REQUEST on endpoint /customer/");
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        log.info("Receive UPDATE-REQUEST on endpoint /customer/{}", id);
        return customerService.updateCustomer(id, customerDTO);
    }
}
