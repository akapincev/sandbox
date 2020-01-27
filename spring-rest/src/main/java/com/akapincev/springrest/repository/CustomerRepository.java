package com.akapincev.springrest.repository;

import com.akapincev.springrest.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findById(long id);
}
