package com.akapincev.springrest.utils;

import com.akapincev.springrest.dto.CustomerDTO;
import com.akapincev.springrest.entity.CustomerEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerMapperTest {

    private static CustomerEntity customerEntity = new CustomerEntity();

    @BeforeAll()
    static void setUp(){
        customerEntity.setFirstName("Johann");
        customerEntity.setLastName("Goldman");
        customerEntity.setSalutation("Herr");
    }

    @Test
    void toCustomerDTO() {
        CustomerDTO customerDTO = CustomerMapper.INSTANCE.toCustomerDTO(customerEntity);

        assertThat(customerDTO).isNotNull();
        assertThat(customerDTO.getFirstName()).isEqualTo("Johann");
        assertThat(customerDTO.getLastName()).isEqualTo("Goldman");
        assertThat(customerDTO.getSalutation()).isEqualTo("Herr");
    }

    @Test
    void toCustomerDTOList() {
        List<CustomerDTO> customers = CustomerMapper.INSTANCE.toCustomerDTOList(Collections.singletonList(customerEntity));
        assertThat(customers).isNotNull();
        assertThat(customers.get(0).getFirstName()).isEqualTo("Johann");
        assertThat(customers.get(0).getLastName()).isEqualTo("Goldman");
        assertThat(customers.get(0).getSalutation()).isEqualTo("Herr");
    }

    @Test
    void toCustomerEntity() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Roman");
        customerDTO.setLastName("Friedrich");
        customerDTO.setSalutation("Herr");

        CustomerEntity customerEntity = CustomerMapper.INSTANCE.toCustomerEntity(customerDTO);
        assertThat(customerEntity).isNotNull();
        assertThat(customerEntity.getFirstName()).isEqualTo("Roman");
        assertThat(customerEntity.getLastName()).isEqualTo("Friedrich");
        assertThat(customerEntity.getSalutation()).isEqualTo("Herr");
    }
}