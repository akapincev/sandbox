package com.akapincev.springrest.utils;

import com.akapincev.springrest.dto.CustomerDTO;
import com.akapincev.springrest.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toCustomerDTO(CustomerEntity customerEntity);

    List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntityList);

    CustomerEntity toCustomerEntity(CustomerDTO customerDTO);
}
