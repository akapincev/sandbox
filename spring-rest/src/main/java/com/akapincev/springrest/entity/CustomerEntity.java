package com.akapincev.springrest.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity {

    private String firstName;

    private String lastName;

    private String salutation;

    public CustomerEntity(String firstName, String lastName, String salutation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salutation = salutation;
    }
}
