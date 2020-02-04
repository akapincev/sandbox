package com.akapincev.feignclient.client;

import com.akapincev.feignclient.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "customer-client", url = "localhost:9090/customer", configuration = ClientConfiguration.class)
public interface CustomerClient {

    @GetMapping(value = "{id}")
    CustomerDTO findCustomerById(@PathVariable("id") long id);

    @GetMapping()
    List<CustomerDTO> findAllCustomers();

    @PostMapping()
    CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO);

    @PutMapping(value = "{id}")
    CustomerDTO updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO);
}
