package com.akapincev.feignclient.web;

import com.akapincev.feignclient.dto.CustomerDTO;
import com.akapincev.feignclient.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("")
    public List<CustomerDTO> findAllCustomers() {
        log.info("Receive GET-REQUEST on endpoint /customer/");
        return customerService.findAllCustomers();
    }
}
